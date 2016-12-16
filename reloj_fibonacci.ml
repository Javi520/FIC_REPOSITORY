(*iwnbb*)

type colour = W | B | R | G;;

type clock = colour array;;

let colour_at clock i =
    if i >= 1 && i <= 5 then clock.(i-1) 
    else raise (Invalid_argument "colour_at")
;;

let color_en clock i = 
	try
		clock.i
	with
		_ -> raise (Invalid_argument "colour_at")
;; (*me gusta mas asi*)

let all_white = Array.make 5 W;;

type time = {hh:int; mm:int};;

let valid_time t = 
    t.hh >= 0 && t.hh < 24 && t.mm >= 0 && t.mm < 60;;

let normal_time t =
    t.hh > 0 && t.hh <= 12 && t.mm >= 0 && t.mm < 60;;

let rounded_time t = 
    {t with mm = 5 * (t.mm / 5)};;

let time (h,m) = 
    let t = {hh=h;mm=m} in
    if valid_time t then t else invalid_arg "time";;

(*time_of_clock: clock -> time*)




