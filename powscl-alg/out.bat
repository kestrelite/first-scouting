@echo off
:10
set /p r1=R1: 
set /p r2=R2: 
set /p b1=B1: 
set /p b2=B2: 
set /p rs=RS: 
set /p bs=BS: 
echo mL = append(mL, Match{TeamNums: []int{%r1%, %r2%, %b1%, %b2%}, RScore: %rs%, BScore: %bs%, RPen: 0, BPen: 0}) >> out.txt
goto 10