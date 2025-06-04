# Solve s99

[S-99: Ninety-Nine Scala Problems](https://aperiodic.net/pip/scala/s-99/) を解く

```bash
cd s99-solve

# make files for solve and test
./solve.sh ${problem_num}

# run test
sbt "testOnly *Problem${problem_num}Test"
```
