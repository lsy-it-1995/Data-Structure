# C Data Types in C99

## Basic Data Types Definition
|Format Specifier | Type |	Description |
|--|--|--|
|%d | Int |	Stores zero, positive, and negative values without decimal. The value can be signed or unsigned. The value assigned to int is considered positive by default if it is unsigned. |
|%f | Float |	Stores decimal values with single-precision |
|%lf | Double |	It stores decimal values with double-precision |
|%c | Char |	stores a single character |

## Basic Data Types Range and Memory
| Data Type	| Range	| Memory / Storage Size |
|--|--|--|
| short int(signed short int)	| -32,768 to 32,767	| 2 bytes |
| unsigned short int	| 0 to 65,535	| 2 bytes |
| long(singed short int)	| -2,147,483,648 to 2,147,483,647	| 4 bytes |
| unsigned long	| 0 to 4,294,967,295	| 4 bytes |
| int (signed int)	| -32,768 to 32,767 or -2,147,483,648 to 2,147,483,647	| 2 or 4 bytes |
| unsigned int	| 0 to 65,535 or 0 to 4,294,967,295 | 2 or 4 bytes |
| float	| 1.2E-38 to 3.4E+38 (6 decimal places) | 4 bytes |
| double	| 2.3E-308 to 1.7E+308 (15 decimal places) | 8 bytes |
| long double	| 3.4E-4932 to 1.1E+4932 (19 decimal places)	| 16 bytes |
| signed char	| -128 to 127	| 1 byte |
| unsigned char	| 0 to 255 | 1 byte |

[Source Credit](https://www.naukri.com/learning/articles/data-types-in-c-programming-with-examples/)