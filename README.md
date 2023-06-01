# Втора лабораториска вежба по Софтверско инженерство
# Давид Станковски, бр. на индекс 216059

---
## 2. Control Flow Graph:
![controlFlowGraph](https://github.com/itsDavid8/SI_2023_lab2_216059/assets/127624161/85fa0566-ef19-44e3-9c62-ab59f2a68de0)


---
## 3. Цикломатска комплексност:
Цикломатската комплексност на кодов е 11, а се пресметува според бројот на региони во соодветниот Control Flow Graph за кодот плус 1. Бројот на региони во графот е 10, па цикломатската комплексност е 10+1=11.

---
## 4. Тест случаи според критериумот „Every Branch“
![everyBranch](https://github.com/itsDavid8/SI_2023_lab2_216059/assets/127624161/f3968971-c96f-48f3-bc2b-a6e4f2941f0f)


Објаснување за првиот тест случај:
Поради вредноста „null“ на променливата „user“ кодот ќе го помине гранките {A-B, B-V}.
Објаснување за останатите тест случаи:
Слично како првиот тест случај, водејќи се според вредностите на променливите „user“ и „allUsers“ ќе добиеме множество гранки што ќе ги помине кодот при извршување на тест случаите. Унијата на добиените множества од сите тест случаи ќе ни го даде множеството на сите гранки од Control Flow Graph за кодот, па може да воочиме дека петте тест случаи го задоволуваат „Every Branch“ критериумот.

---
## 5. Тест случаи според критериумот „Multiple Condition“
Нека [null] соодветствува со null или празен објект, [X] соодветствува со било која вредност, а [notNull] соодветствува со било која вредност што не е [null]. Бидејќи имаме три услови во „if“ поврзани со логичко „или“, соодветните тест случаи се:
1. user=[null],   user.getPassword()=[X],   user.getEmail()=[X]   ||  очекуваме да се фрли RuntimeException("Mandatory information missing!")
2. user=[notNull],    user.getPassword()=[null], 	user.getEmail()=[X]   ||  очекуваме да се фрли RuntimeException("Mandatory information missing!")
3. user=[notNull],		user.getPassword()=[notNull],	user.getEmail()=[null]   ||  очекуваме да се фрли RuntimeException("Mandatory information missing!")
4. user=[notNull],		user.getPassword()=[notNull],	user.getEmail()=[notNull]   ||  очекуваме да продолжи програмата со нормален тек на работа, без фрлање на некој исклучок

Соодветната табела е:
| test case | user==null | user.getPassword()==null | user.getEmail()==null |
| ---- | ---- | ---- | ---- |
| 1 | T | / | / |
| 2 | F | T | / |
| 3 | F | F | T |
| 4 | F | F | F |
---
