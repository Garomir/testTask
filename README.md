<h1>Тестовое задание "testTask"</h1>
<ul>
  <li><a href="#description">Описание</a></li>
  <li><a href="#functionality">Функционал</a></li>
  <li><a href="#tehnologies">Технологии</a></li>
  <li><a href="#architecture">Архитектура</a></li>
  <li><a href="#instruction">Инструкция по запуску</a></li>
  <li><a href="#api">API</a></li>
  <li><a href="#author">Автор</a></li>
</ul>
<h2><a name="description">Описание</a></h2>
  <h4>Клиент-серверное REST CRUD приложение. Для работы с данными из БД SQLite используется Hibernate. Регистрация с помощью Spring Security. Каждый зарегестрированный пользователь имеет доступ только к своим заметкам. Также используется Dockerfile для запуска приложения в контейнере.</h4>
<h2><a name="functionality">Функционал</a></h2>
  <ul>
    <li>Регистрация пользователя</li>
    <li>Аутентификация</li>
    <li>Создание новой заметки</li>
    <li>Отображение списка всех заметок пользователя</li>
    <li>Удаление заметки</li>
    <li>Отображение последних 10 заметок пользователя</li>
  </ul>
<h2><a name="tehnologies">Технологии</a></h2>
  <ul>
    <li>Spring Boot</li>
    <li>Spring Data Jpa</li>
    <li>Hibernate</li>
    <li>SQLite</li>
    <li>Java 11</li>
    <li>Spring Security</li>
    <li>JWT</li>
    <li>Docker</li>
  </ul>
<h2><a name="architecture">Архитектура</a></h2>
  <h4>Проект реализован по шаблону MVC и разделён на слои:</h4>
  <ol>
    <li>
      <p>Сущности данных:</p>
      <p>1.1 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/entities/Note.java">Note</a> - Модель заметки из БД</p>
      <p>1.2 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/entities/User.java">User</a> - Модель пользователя из БД</p>
      <p>1.3 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/entities/Role.java">Role</a> - Модель роли пользователя из БД</p>
    </li>
    <li>
      <p>Репозитории Jpa:</p>
      <p>2.1 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/repos/NoteRepo.java">NoteRepo</a> - Интерфейс для взаимодействия с заметками из БД</p>
      <p>2.2 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/repos/UserRepo.java">UserRepo</a> - Интерфейс для взаимодействия с пользователями из БД</p>
      <p>2.3 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/repos/RoleRepo.java">RoleRepo</a> - Интерфейс для взаимодействия с ролями пользователей из БД</p>
    </li>
    <li>
      <p>Сервисный слой с бизнес-логикой:</p>
      <p>3.1 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/services/NoteService.java">NoteService</a> - Интерфейс со списком методов по работе с заметками</p>
      <p>3.2 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/services/NoteServiceImpl.java">NoteServiceImpl</a> - Реализация методов из интерфейса NoteService</p>
      <p>3.3 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/services/UserService.java">UserService</a> - Интерфейс со списком методов по работе с пользователями</p>
      <p>3.4 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/services/UserServiceImpl.java">UserServiceImpl</a> - Реализация методов из интерфейса UserService</p>
      <p>3.5 <a href="https://github.com/Garomir/testTask/blob/master/src/main/java/com/ramich/testTask/services/UserDetailsServiceImpl.java">UserDetailsServiceImpl</a> - Реализация интерфейса UserDetailsService для преобразования пользователя в UserDetails</p>
    </li>
  </ol>
<h2><a name="instruction">Инструкция по запуску</a></h2>
    <ol>
        <li><p>Открываем терминал.</p></li>
        <li><p>С помощью git клонируем проект к себе на компьютер:</br>
	        git clone https://github.com/Garomir/testTask</p></li>
        <li><p>Переходим в папку с проектом:</br>
	        cd {путь к папке}/testTask</p></li>
        <li><p>Собираем образ из Dockerfile командой:</br>
	        docker build -t testtask .</p></li>
        <li><p>Запускаем контейнер командой:</br>
	        docker run -d -p 8080:8080 -t testtask</p></li>
        <li><p>Используя Postman тестируем API нашего приложения:</p>
<h2><a name="api">API</a></h2>
    <p>Доступ для всех:</p>
    <ul>
        <li>GET	http://localhost:8080/			- home</li>
        <li>POST	http://localhost:8080/registration	- регистрация, отправляем json(логин,пароль)</li>
        <li>POST	http://localhost:8080/login		- аутентификация, отправляем json(логин,пароль), получаем токен</li>
    </ul>
    <p>Доступ для залогиненных пользователей с полученным токеном:</p>
    <ul>
        <li>POST	http://localhost:8080/notes		- добавить новую заметку, отправляем json(message)</li>
        <li>GET	http://localhost:8080/notes		- получить список всех заметок пользователя</li>
        <li>GET	http://localhost:8080/notes/history10	- получить последние 10 заметок пользователя</li>
        <li>GET	http://localhost:8080/getusers		- получить список всех пользователей</li>
        <li>DELETE	http://localhost:8080/notes/{id}	- удалить заметку по ее id</li>
    </ul>
<h2><a name="author">Автор</a></h2>
  <p>Сафуанов Рамиль</p>
  <p>Java-разработчик</p>
  <p><a href="mailto:ramilfin@mail.ru">ramilfin@mail.ru</a></p>
  <p>+7 9172282922</p>
