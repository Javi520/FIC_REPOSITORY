//hola estoy probando el sistema de github para hostear un proyecto conjunto
procedure Cancelacion(cliente:tNombreEspectador;cantidad:integer);
var i:integer;
butaca:tPosR;
Usuario:tPosU;
begin
  Usuario:=BuscarDatoU(cliente,listaU);
  if Usuario=NULOU then writeln("+++ERROR DE CANCELACION: RESERVA INEXISTENTE")
  else begin
    butaca:=PrimeraR(listaR);
    while (i<>cantidad)or(Butaca=NULOU) do begin
    writeln("Cancelacion de ",cliente);
          eliminarPosicionR(butaca,listaR);
          writeln("Butaca",i:0,cliente);
          butaca:=siguienteR(butaca,listaR);
          i:=i+1;
    end;
    if butaca=NULOU then begin
    writeln("Eliminando Usuario");
    eliminarPosicionU(Usuario,listaU);
    end;
  end;
end;
