package com.example.rentProject.config;

import org.springframework.boot.ApplicationRunner;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rentProject.models.TypeOfRenter;
import com.example.rentProject.models.TypeOfRoom;
import com.example.rentProject.repository.TypeOfRenterRepository;
import com.example.rentProject.repository.TypeOfRoomRepository;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer implements ApplicationRunner{
    private final TypeOfRoomRepository typeOfRoomRepository;
    private final TypeOfRenterRepository typeOfRenterRepository;

    public DataInitializer(TypeOfRoomRepository typeOfRoomRepository, TypeOfRenterRepository typeOfRenterRepository) {
        this.typeOfRoomRepository = typeOfRoomRepository;
        this.typeOfRenterRepository = typeOfRenterRepository;
    }

     @Override
    public void run(ApplicationArguments args) throws Exception {
        // Инициализация данных для TypeOfRoom
        List<TypeOfRoom> initialRoomData = Arrays.asList(
                new TypeOfRoom ("Секция/Подъезд"),
            new TypeOfRoom ("Этаж"),
            new TypeOfRoom ("Квартира"),
            new TypeOfRoom ("Коридор"),
            new TypeOfRoom ("Санузел"),
            new TypeOfRoom ("Ванная"),
            new TypeOfRoom ("Кухня"),
            new TypeOfRoom ("Балкон"),
            new TypeOfRoom ("Всроенный шкаф")
                // Добавьте столько объектов TypeOfRoom, сколько вам нужно
        );

        // Инициализация данных для TypeOfRenter
        List<TypeOfRenter> initialRenterData = Arrays.asList(
                new TypeOfRenter ("Квартиросъемщик"),
                new TypeOfRenter( "Наниматель коммерческих помещений"),
                new TypeOfRenter( "Администрация ТСЖ")
                // Добавьте столько объектов TypeOfRenter, сколько вам нужно
        );

        // Сохранение данных в соответствующих репозиториях
        typeOfRoomRepository.saveAll(initialRoomData);
        typeOfRenterRepository.saveAll(initialRenterData);
    }
    /* 
    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Ваши инициализационные данные
            TypeOfRenter entity1 = new TypeOfRenter (1,"Квартиросъемщик");
            TypeOfRenter entity2 = new TypeOfRenter(2, "Наниматель коммерческих помещений");
            TypeOfRenter entity3 = new TypeOfRenter(3, "Администрация ТСЖ");

            new TypeOfRoom (1,"Секция/Подъезд"),
            new TypeOfRoom (2,"Этаж"),
            new TypeOfRoom (3,"Квартира"),
            new TypeOfRoom (4,"Коридор"),
            new TypeOfRoom (5,"Санузел"),
            new TypeOfRoom (6,"Ванная"),
            new TypeOfRoom (7,"Кухня"),
            new TypeOfRoom (8,"Балкон"),
            new TypeOfRoom (9,"Всроенный шкаф")

            // Сохранение данных в репозитории
            typeOfRenterRepository.save(entity1);
            typeOfRenterRepository.save(entity2);
            typeOfRenterRepository.save(entity3);

            typeOfRoomRepository.save(entity4);
            typeOfRoomRepository.save(entity5);
            typeOfRoomRepository.save(entity6);
            typeOfRoomRepository.save(entity7);
            typeOfRoomRepository.save(entity8);
            typeOfRoomRepository.save(entity9);
            typeOfRoomRepository.save(entity10);
            typeOfRoomRepository.save(entity11);
            typeOfRoomRepository.save(entity12);
            
        };
    }*/
}
