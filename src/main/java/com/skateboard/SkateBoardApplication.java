package com.skateboard;

import com.skateboard.DTO.Parts;
import com.skateboard.DTO.Parts.Type;
import com.skateboard.data.PartsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SkateBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkateBoardApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(PartsRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.save(new Parts("MOBGRIP","MOB Grip tape", Type.GRIP_TAPE));
                repo.save(new Parts("GRZGRIP","Grizzly Grip tape",Type.GRIP_TAPE));
                repo.save(new Parts("JSUGRIP","Jessup Grip tape",Type.GRIP_TAPE));
                
                repo.save(new Parts("SUP_DECK","Supreme Deck",Type.DECK));
                repo.save(new Parts("BAK_DECK","Baker Deck",Type.DECK));
                repo.save(new Parts("STC_DECK","Santacruz Deck",Type.DECK));
                
                repo.save(new Parts("ACE_TRUCK_STA_44","Ace Truck, Standard 44Size",Type.TRUCK));
                repo.save(new Parts("IND_TRUCK_HOL_139","Independent Truck, Hollow  139Size",Type.TRUCK));
                
                repo.save(new Parts("BNS_WHEEL_99A","Bones Wheel, 54mm 99A",Type.WHEEL));
                repo.save(new Parts("SPF_WHEEL_101A","Spitfire Wheel, 56mm 101A",Type.WHEEL));
                
                repo.save(new Parts("BNS_BEARING_REDS","Bones Reds",Type.BEARING));
                repo.save(new Parts("BRS_BEARING_G3","Bronson G3",Type.BEARING));

                repo.save(new Parts("BRO_HARDWARE_7_8","Bronze 56k 7/8\"",Type.HARDWARE));
                repo.save(new Parts("IND_HARDWARE_1","Independent 1\"",Type.HARDWARE));
            }
        };
    }
}
