param X;
param Y;
param Z;

var a >= 0;
var b >= 0;
var l >= 0;

s.t. ograniczenie1: a + b + l = X;
s.t. ograniczenie2: a + b <= 0.5 * X;
s.t. ograniczenie3: b <= Y;
s.t. ograniczenie4: l >= Z;

maximize zysk: 0.09 * a + 0.11 * b + 0.10 * l;

solve;
printf "%.2f \n", zysk; 
end;
