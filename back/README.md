# Документация API `core-api`

## Описание

`core-api` предназначен для управления домами, комнатами и устройствами в них.

## Серверы

- Базовый URL: `/slon-house`

## Пути

### Создать дом

**`POST /houses`**

Создает новый дом.

#### Теги

- House

#### Запрос

Тело запроса (required):

- **Content-Type**: `application/json`
- **Schema**: `NewHouse`

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: `House`

### Получить дом по ID

**`GET /houses/{houseId}`**

Возвращает дом по заданному ID.

#### Теги

- House

#### Параметры

- **houseId**: `BaseID` (required, in: path)

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: `House`

- **404 Not found**

### Создать комнату в доме

**`POST /houses/{houseId}/rooms`**

Создает новую комнату в доме.

#### Теги

- Room

#### Параметры

- **houseId**: `BaseID` (required, in: path)

#### Запрос

Тело запроса (required):

- **Content-Type**: `application/json`
- **Schema**: `NewRoom`

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: `Room`

### Получить все комнаты в доме

**`GET /houses/{houseId}/rooms`**

Возвращает все комнаты в доме.

#### Теги

- Room

#### Параметры

- **houseId**: `BaseID` (required, in: path)

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: 
    - type: array
    - items:
      - `$ref`: `#/components/schemas/Room`

- **400 Bad request**

- **404 Not found**

### Получить комнату по ID

**`GET /houses/{houseId}/rooms/{roomId}`**

Возвращает комнату по заданному ID.

#### Теги

- Room

#### Параметры

- **houseId**: `BaseID` (required, in: path)
- **roomId**: `BaseID` (required, in: path)

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: `Room`

- **400 Bad request**

- **404 Not found**

### Создать устройство в комнате

**`POST /houses/{houseId}/rooms/{roomId}/devices`**

Создает новое устройство в комнате.

#### Теги

- Device

#### Параметры

- **houseId**: `BaseID` (required, in: path)
- **roomId**: `BaseID` (required, in: path)

#### Запрос

Тело запроса (required):

- **Content-Type**: `application/json`
- **Schema**: `NewDevice`

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: `Device`

### Получить все устройства в комнате

**`GET /houses/{houseId}/rooms/{roomId}/devices`**

Возвращает все устройства в комнате.

#### Теги

- Device

#### Параметры

- **houseId**: `BaseID` (required, in: path)
- **roomId**: `BaseID` (required, in: path)

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: 
    - type: array
    - items:
      - `$ref`: `#/components/schemas/Device`

- **400 Bad request**

- **404 Not found**

### Получить устройство по ID

**`GET /houses/{houseId}/rooms/{roomId}/devices/{deviceId}`**

Возвращает устройство по заданному ID.

#### Теги

- Device

#### Параметры

- **houseId**: `BaseID` (required, in: path)
- **roomId**: `BaseID` (required, in: path)
- **deviceId**: `BaseID` (required, in: path)

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: `Device`

- **400 Bad request**

- **404 Not found**

### Удалить устройство по ID

**`DELETE /houses/{houseId}/rooms/{roomId}/devices/{deviceId}`**

Удаляет устройство по заданному ID.

#### Теги

- Device

#### Параметры

- **houseId**: `BaseID` (required, in: path)
- **roomId**: `BaseID` (required, in: path)
- **deviceId**: `BaseID` (required, in: path)

#### Ответы

- **200 OK**

- **400 Bad request**

- **404 Not found**

### Изменить значение триггера

**`PUT /houses/{houseId}/rooms/{roomId}/devices/{deviceId}/trigger`**

Изменяет значение триггера устройства.

#### Теги

- Device

#### Параметры

- **houseId**: `BaseID` (required, in: path)
- **roomId**: `BaseID` (required, in: path)
- **deviceId**: `BaseID` (required, in: path)
- **amount**: (required, in: query)

#### Ответы

- **200 OK**

  - **Content-Type**: `application/json`
  - **Schema**: `Device`

- **400 Bad request**

- **404 Not found**

### Переместить устройство в указанную комнату

**`PATCH /houses/{houseId}/devices/{deviceId}/room/{roomId}`**

Перемещает устройство в указанную комнату.

#### Теги

- Device

#### Параметры

- **houseId**: `BaseID` (required, in: path)
- **roomId**: `BaseID` (required, in: path)
- **deviceId**: `BaseID` (required, in: path)

#### Ответы

- **200 OK**

- **400 Bad request**

- **404 Not found**

## Компоненты

### Схемы

#### House

- **type**: object
- **allOf**:
  - `$ref`: `#/components/schemas/NewHouse`
- **required**:
  - `id`
  - `createdAt`
  - `updatedAt`
- **properties**:
  - `id`:
    - `$ref`: `#/components/schemas/BaseID`
  - `createdAt`:
    - **type**: string
    - **format**: date-time
  - `updatedAt`:
    - **type**: string
    - **format**: date-time

#### NewHouse

- **type**: object
- **required**:
  - `name`
  - `userLogin`
- **properties**:
  - `name`:
    - **type**: string
    - **example**: Slon house
  - `userLogin`:
    - **type**: string
    - **example**: AlexG2004

#### BaseID

- **type**: string
- **format**: uuid

#### Room

- **type**: object
- **allOf**:
  - `$ref`: `#/components/schemas/NewRoom`
- **required**:
  - `id`
  - `houseId`
- **properties**:
  - `id`:
    - `$ref`: `#/components/schemas/BaseID`
  - `houseId`:
    - `$ref`: `#/components/schemas/BaseID`

#### NewRoom

- **type**: object
- **required**:
  - `name`
- **properties**:
  - `name`:
    - **type**: string
    - **example**: Туалет

#### Device

- **type**: object
- **allOf**:
  - `$ref`: `#/components/schemas/NewDevice`
- **required**:
  - `id`
  - `state`
  - `roomId`
- **properties**:
  - `id`:
    - `$ref`: `#/components/schemas/BaseID`
  - `roomId`:
    - `$ref`: `#/components/schemas/BaseID`
  - `state`:
    - **type**: boolean

#### NewDevice

- **type**: object
- **properties**:
  - `name`:
    - **type**: string
    - **example**: Лампа
  - `type`:
    - `$ref`: `#/components/schemas/DeviceType`
  - `triggerAmount`:
    - **type**: integer
    - **example**: 5

#### DeviceType

- **type**: string
- **enum**:
  - ONLY_MANUAL
  - TEMPERATURE
  - LIGHT
