param n;
param c{i in 0..n, j in 0..n};

set V := 0..n;
set E := V cross V;

var x{(i, j) in E}, binary;

s.t. ograniczenie1{i in V}: sum{j in V} x[i, j] = 1;
s.t. ograniczenie2{i in V}: sum{j in V} x[j, i] = 1;
s.t. ograniczenie3{(i, j) in E : i == j}: x[i, i] = 0;
s.t. ograniczenie4{(i, j) in E : i < j}: x[i, j] + x[j, i] <= 1;
      
minimize czas: sum{(i,j) in E} c[i,j] * x[i,j];

solve;
printf "%.2f \n", czas;
end;
