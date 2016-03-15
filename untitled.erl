%%primer programa en erlang
-module(gestor).

-export([start/0, alloc/3, get/2, del/2, stop/1]). % Api

-export([init/1]).

%%% API %%%%

start() ->
	spawn(?MODULE, init, []).
	%o eso o % spawn(?MODULE, fun() -> init([])). %quitando el export([init/1]). que es para lo que vale esto

alloc(Servidor, QuienSoy, Value) ->
	Servidor ! {alloc, QuienSoy, Value}.

get(Servidor, QuienSoy) ->
	Servidor ! {get, QuienSoy, self()},
	receive
		{hash_ok, V} ->
			{ok, V};
		{resource_error, Reason} -> 
			{error, Reason}
	end.

del(Servidor, QuienSoy) ->
	Servidor ! {del, QuienSoy}.
	
stop(Servidor) ->
	Servidor ! stop.

%%% Internal functions %%%%%

init(D) when is_list(D)->
	loop(D).

loop(D) ->
	receive
		{alloc, NK, NV} ->
			loop([{NK,NV} | [{K, V} || {K, V} <- D, K/=NK]]);
		{get, K, From} ->
			From ! find(K, D),
			loop(D);
		{del, KD} ->
			loop([{K, V} || {K,V} <- D, K/=KD]); 
		stop ->
			ok
	end.

find(_, []) -> {resource_error, not_found};
find(K, [{K,V} | _]) -> {resource_ok, V};
find(K, [_|T]) -> find(K, T).


