set Pestycydy;
set Skladniki;
param cena{Pestycydy};
param zawartosc{Skladniki, Pestycydy};
param norma{Skladniki};

var x{i in Pestycydy} >= 0;

s.t. ograniczenie1 {s in Skladniki}: sum{i in Pestycydy} zawartosc[s, i] * x[i] >= norma[s];

minimize koszt: sum{i in Pestycydy} cena[i] * x[i];

solve; 
printf "%.2f \n", koszt;
end;
