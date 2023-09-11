(LOOP1)
@i
M=0
@j
M=0
@24576
D=M
@PUSH
D;JEQ
@COLOR
M=0
@LOOP2
0;JMP
(PUSH)
@COLOR
M=1


(LOOP2)
@i
D=M
@256
D=D-A
@LOOP1
D;JGT
@i
M=M+1
@j
M=0
(LOOP3)
@j
D=M
@512
D=D-A
@LOOP2
D;JGT
@j
D=M
@SCREEN
D=D+A
@0
M=D
@i
D=M
@1
M=D
@MUL
0;JMP
(DRAW)
@2
D=M
A=D
M=-1
@j
M=M+1

@LOOP3
0;JMP
(MUL)
@k
M=0 // i = 0
@2
M=0     // R2 = 0




(LOOP)  // if (R1 - i) = 0 goto END
@k
D=M
@1
D=M-D
@END
D;JEQ
@0
D=M
@2      // R2 += R0
M=D+M
@k
M=M+1   
@LOOP
0;JMP
(END)
@DRAW
0;JMP