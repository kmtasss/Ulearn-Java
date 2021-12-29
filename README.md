# Итоговое задание по Java Ulearn

## Начало работы с проектом

#### _1.Первым шагом было создание базы данных sqlite и добавления соответствующего моему варианту csv файла._

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/start1.png)


#### _2.После ознакомления с csv файлом, нужно было создать POJO класс, который бы хранил данные по каждому событию после парсинга._

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/pojo.png)


## Работа с базой данных

#### _1.Создали специальный класс DatabaseSqlite, в котором происходит взаимодействие с базой данных "sport.db"_


#### _2.В классе мы описали подключение и отсоединение базы данных, создание и заполнение таблиц:_

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/tableCreating.png) <br> 

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/fillingTable.png)


## Ответы на вопросы по варианту csv файла

#### _1 вопрос: Постройте график по количеству участников спортивных мероприятий объеденив их по виду спорта_

Запрос в базу данных sport.db:

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/firstQ.png)

График по этому заданию:

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/barchart.png)

#### _2 вопрос: Выведите в консоль количество участников за 2008 год, по каждой стране_

Запрос в базу данных sport.db:

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/secondQ.png)

Результат:

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/secondA.png)

#### _3 вопрос: Выведите в консоль самое массовое мероприятие среди молодежных (резервных) составов по восточным боевым единоборствам_

Запрос в базу данных sport.db:

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/thirdQ.png)

Результат:

![](https://github.com/kmtasss/Ulearn-Java/blob/master/images/thirdA.png)
