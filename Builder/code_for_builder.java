package Builder;

// Строитель может создавать различные продукты, используя один
// и тот же процесс строительства.
class Car {}
// Автомобили могут отличаться комплектацией: типом
// двигателя, количеством сидений, могут иметь или не иметь
// GPS и систему навигации и т. д. Кроме того, автомобили
// могут быть городскими, спортивными или внедорожниками.

class Manual {}
// Руководство пользователя для данной конфигурации
// автомобиля.


// Интерфейс строителя объявляет все возможные этапы и шаги
// конфигурации продукта.
interface Builder {
    static void setTripComputer(boolean b) {
    }

    static void setGPS(boolean b) {
    }

    static void reset() {

    }

    static void setSeats(int i) {
    }

    void setSeats();
    void setEngine();
    void setTripComputer();
    void setGPS();

    public class Manual {
    }
}
// Все конкретные строители реализуют общий интерфейс по-своему.
class CarBuilder implements Builder {
        private Car car;

    public void reset() {
        
    }

    // Поместить новый объект Car в поле "car".
        public void setSeats() {}
        // Установить указанное количество сидений.
        public void setEngine() {}
        // Установить поданный двигатель.
        public void setTripComputer() {}
        // Установить поданную систему навигации.
        public void setGPS() {}
        // Установить или снять GPS.
        Manual getResult(){

            return null;
        }
        }
// Вернуть текущий объект автомобиля.

// В отличие от других порождающих паттернов, где продукты
// должны быть частью одной иерархии классов или следовать
// общему интерфейсу, строители могут создавать совершенно
// разные продукты, которые не имеют общего предка.
class CarManualBuilder implements Builder {
    private Manual manual;

    public void reset() {
    }

    // Поместить новый объект Manual в поле "manual".
    public void setSeats() {

    }

    // Описать, сколько мест в машине.
    public void setEngine() {

    }

    // Добавить в руководство описание двигателя.
    public void setTripComputer() {

    }

    // Добавить в руководство описание системы навигации.
    public void setGPS() {

    }

    // Добавить в инструкцию инструкцию GPS.
    Builder.Manual getResult() {

        return null;
    }
}
// Вернуть текущий объект руководства.


// Директор знает, в какой последовательности нужно заставлять
// работать строителя, чтобы получить ту или иную версию
// продукта. Заметьте, что директор работает со строителем через
// общий интерфейс, благодаря чему он не знает тип продукта,
// который изготовляет строитель.
class Director {
    void constructSportsCar(){
        Builder.reset();
        Builder.setSeats(2);
        Builder.setTripComputer(true);
        Builder.setGPS(true);
    }
}

// Директор получает объект конкретного строителя от клиента
// (приложения). Приложение само знает, какого строителя нужно
// использовать, чтобы получить определённый продукт.
class Application {
    private Object Application;

    void makeCar() {

        Application =new Director();

    CarBuilder builder = new CarBuilder();

    // Готовый продукт возвращает строитель, так как
    // директор чаще всего не знает и не зависит от
    // конкретных классов строителей и продуктов.
    Builder.Manual manual = builder.getResult();
    }
}