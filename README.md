# COSC_OP_SYS
Private Operating System Simulation

This is an academic project for bowie state university

This application is intended to simulate a simple operating system as follows:

Ten processes are stored in main memory at an given time. 
These processes will reference scripts written in a scripting langauge (TBD)
Each process is to have a PCB (Process Control Block) and are stored in one of two available Queues.

These available Queues include:
A. Ready Queue - Those processes not yet partially or entirely executed
B. Blocked Disk Queue - Those processed that are partially executed but require further CPU and disk memory to complete

A Memory Manager is used to manage a limited memory space and controls the execution of the processes via a paging approach.

Each Page in memory has a size of 128 bytes.


