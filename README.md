# Итоговый проект к модулю Java Syntax. Пишем криптоанализатор
## Шифр Цезаря
Это один из самых простых и известных методов шифрования. Назвали его, само собой, в честь императора Гая Юлия Цезаря, применявшего его для секретной переписки с генералами.

Шифр Цезаря — это шифр подстановки: в нем каждый символ в открытом тексте заменяют на символ, который находится на некотором постоянном числе позиций левее или правее него в алфавите.

Допустим, мы устанавливаем сдвиг на 3. В таком случае А заменится на Г, Б станет Д, и так далее.

Это минимум теоретических данных, которые понадобятся тебе для выполнения итогового проекта. Переходим к описанию задания!
## Задача: написать программу, которая работает с шифром Цезаря.

За основу криптографического алфавита возьми все буквы русского алфавита и знаки пунктуации (. , ”” : - ! ? ПРОБЕЛ). Если попадаются символы, которые не входят в наш криптографический алфавит, просто пропусти их.

### Обязательные требования
У программы должно быть 2 режима:

Шифрование / расшифровка. Программа должна зашифровывать и расшифровывать текст, используя заданный криптографический ключ.

Программа должна получать путь к текстовому файлу с исходным текстом и на его основе создавать файл с зашифрованным текстом.

Криптоанализ методом brute force

Программа должна взламывать зашифрованный текст, переданный в виде текстового файла.

Если пользователь выбирает brute force (брутфорс, поиск грубой силой), программа должна самостоятельно, путем перебора, подобрать ключ и расшифровать текст.

Подумай, какой критерий программа должна воспринимать как сигнал успешного подбора ключа. Возможно, нужно обратить внимание на пробелы между словами или правильность использования знаков пунктуации.
