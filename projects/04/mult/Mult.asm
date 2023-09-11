// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
//
// This program only needs to handle arguments that satisfy
// R0 >= 0, R1 >= 0, and R0*R1 < 32768.

// Put your code here.
@i
M=0 // i = 0
@2
M=0     // R2 = 0
(LOOP)  // if (R1 - i) = 0 goto END
@i
D=M
@1
D=M-D
@END
D;JEQ
@0
D=M
@2      // R2 += R0
M=D+M
@i
M=M+1   
@LOOP
0;JMP
(END)
0;JMP