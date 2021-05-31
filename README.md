# Втора лабораториска вежба по Софтверско инженерство

## Сања Петрушевска, бр. на индекс 183175

###  Control Flow Graph

![Alt text](CFG.jpg?raw=true "CFG")

### Цикломатска комплексност

Цикломатската комплексност на овој код е 8, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=7, па цикломатската комплексност изнесува 8.

### Тест случаи според критериумот  Every branch
#### Input, Expected Output

Time(10, 0, 0), 10 * 60 * 60

Time(10, 59, 0), 10 * 60 * 60 + 59 * 60

Time(24, 0, 0), 24 * 60 * 60

Time(10, 59, 59), 10 * 60 * 60 + 59 * 60 + 59

Time(-1, 0, 0), "The hours are smaller than the minimum"

Time(25, 0, 0), "The hours are grater than the maximum"

Time(23, -1, 0), "The minutes are not valid!"

Time(23, 60, 0), "The minutes are not valid!"

Time(23, 59, -1), "The seconds are not valid"

Time(23, 59, 60), "The seconds are not valid"

Time(24, 59, 60), "The time is greater than the maximum"

### Објаснување на напишаните unit tests
За тестовите кои не треба да фрлат Exception го проверувам добиениот резултат дали е ист со очекуваниот.

За тестовите кои треба да фрлат Exception, проверувам дали навистина фрлиле Exception и дали exceptionMessage e ист со очекуваната Exception порака.
