set R;
param P;
param N;
param Z{R};
param W{R};
param C{R};

var x{i in R}, integer >= 0;

s.t. ograniczenie1: sum{i in R} Z[i] * x[i] <= P; 
s.t. ograniczenie2: sum{i in R} W[i] * x[i] >= N;

minimize maszyny: sum{i in R} C[i] * x[i];

solve;
printf{i in R} "%3s %3d \n", i, x[i];
end;
