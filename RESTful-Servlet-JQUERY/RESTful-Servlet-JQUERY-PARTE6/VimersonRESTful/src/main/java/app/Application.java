package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication
@Controller
public class ApplicationClass{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClass.class, args);
	}
}

A classe SpringApplication vai ler as configurações da classe passada como argumento e pronto, você
tem a sua aplicação no ar. A anotação @SpringBootApplication essa anotação encapsula algumas outras
anotações, como a @EnableAutoConfiguration que carrega, por sua vez, a @AutoConfigurationPackages que 
é responsável por configurar os pacotes que devem ser escaneados, baseados na localização da usa classe.

   
@SpringBootApplication
Para quem usa Spring Boot, essa é uma das primeiras que você. Ela engloba a @Component, @ComponentScan e 
mais uma chamada @EnableAutoConfiguration, que é utilizada pelo Spring Boot para tentar advinhar as 
configurações necessárias para rodar o seu projeto.


Uma coisa acontece por baixo dos panos, o Spring tem um Tomcat embutido, quando colocamos o Spring Boot
tem o seu próprio Tomcat embutido
*/

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
