package br.com.mslogisticaentrega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MsLogisticaEntregaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLogisticaEntregaApplication.class, args);
	}

}
