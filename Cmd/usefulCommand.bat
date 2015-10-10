SETLOCAL

@echo off

REM comment

REM Redirect any error to a file
cmd > filename       
REM Appen any error to a file
cmd >> filename   
REM Redirect errors and output to a single file
cmd > file 2>&1       
REM Redirect output and errors to separate files 
cmd > fileA 2> fileB  
