Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм

Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин. На базе описания персонажей описать простейшую иерархию классов. В основной программе создать по одному экземпляру каждого класса.

Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования

Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo(); Реализовать интерфейс в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа. Создать два списка в классе main. В каждый из списков добавить по десять случайных экземнляров наследников BaseHero. Удалить ненужные методы из абстрактного класса, если такие есть. В main пройти по спискам и вызвать у всех персонажей getInfo.

Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования

Создать класс с описанием координат, x и y.
Добавить в абстрактный класс поле с координатами и пробросить его инициализацию до конструкторов персонажей. Farmer farmer = new Farmer(getName(), x, y);
Найти среди противников ближайшего и вывести расстояние до него и его имя в консоль.

Урок 4.
1. Если жизни 0 вернуть управление
2. Если стрел 0 вернуть управление
3. Найти ближайшего противника
4. Нанести ему среднее повреждение
5. Если среди своих есть крестьянин вернуть управление
6. Уменьшить кол-во стрел на одну и вернуть управление

Вызывать персонажей из обеих комманд в порядке инициативы.

Урок 5.
Реализовать визуализацию своего проекта по примеру семинара с использованием приложенных классов. Доработать степ крестьян и магов!

Урок 6-7.
Делаем ход пехоты!
1. Проверяем здоровье
2. Ищем ближайшего врага
3. Двигаемся в сторну врага
4. Не наступаем на живых персонажей
5. Если расстояние до врага одна клетка бём его!