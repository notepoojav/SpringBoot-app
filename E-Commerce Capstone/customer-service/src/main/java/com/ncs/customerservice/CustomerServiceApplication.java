package com.ncs.customerservice;

import com.ncs.customerservice.entity.Product;
import com.ncs.customerservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Autowired
	ProductRepository productRepository;

	@Bean
	public void setup(){
//		productRepository.save(new Product( null, "Decoration dish" , 20, "Handmade in jute" , "lifestyle","https://www.ikea.com/sg/en/images/products/noejaktig-decoration-dish-rattan__1008867_pe827348_s5.jpg?f=xxs" , 13 ));
//		productRepository.save(new Product( null, "Cushion" , 20, "Hand woven in pink " , "Utility","https://www.ikea.com/sg/en/images/products/kransborre-cushion-light-pink__1009482_pe827611_s5.jpg?f=xxs" , 50 ));
//		productRepository.save(new Product( null, "Artificial Plants" , 20, "Home Decor item" , "Lifestyle","https://www.ikea.com/sg/en/images/products/fejka-artificial-plant-wall-mounted-in-outdoor-green-lilac__0900304_pe660547_s5.jpg?f=xxs" , 20 ));
//		productRepository.save(new Product( null, "Decoration hand" , 20, "Home decor fancy" , "Lifestyle","https://www.ikea.com/sg/en/images/products/handskalad-decoration-hand-natural__1091032_pe862269_s5.jpg?f=xxs" , 30 ));
//		productRepository.save(new Product( null, "Vollyball" , 20, "Vector X Spike Rubber Vollyball" , "sports","https://m.media-amazon.com/images/I/711ggpyjO+L._SX679_.jpg" , 380 ));
//		productRepository.save(new Product( null, "UNO" , 20, "Mattel Uno Playing Card Game" , "Games","https://m.media-amazon.com/images/I/812Yr9WChrL._SX569_.jpg" , 25 ));
//		productRepository.save(new Product( null, "Fujifilm Instax Mini9" , 20, "Instant Camera(Ice Blue)" , "Lifestyle","https://m.media-amazon.com/images/I/41jEKwi7giL.jpg" , 300 ));
//		productRepository.save(new Product( null, "Wireless speaker" , 20, "Zebronics black bluetooth" , "Lifestyle","https://m.media-amazon.com/images/I/81v-h4I5CCL._SX679_.jpg" , 90 ));
//		productRepository.save(new Product( null, "Aluminium Badminton Racket" , 20, "With full cover set" , "sports","https://m.media-amazon.com/images/S/onsitepublishing-media-prod/71b07008-15a1-48ea-816c-b4bcc265172f/images/083d3e75-5857-4d4e-bacf-b53b3ecce019.jpg" , 20 ));
//		productRepository.save(new Product( null, "Monopoly" , 20, "Card games" , "Games","https://w7.pngwing.com/pngs/521/166/png-transparent-monopoly-deal-monopoly-plus-monopoly-junior-hasbro-monopoly-monopoly-man-game-text-logo-thumbnail.png" , 15 ));
//		productRepository.save(new Product( null, "Curtain covers" , 20, "Orange-brown curtains" , "Lifestyle","https://www.ikea.com/sg/en/images/products/bengta-block-out-curtain-1-length__1056519_pe848368_s5.jpg?f=s" , 13 ));
//		productRepository.save(new Product( null, "Inset Sink" , 20, "Aesthetic and simple" , "Lifestyle","https://www.ikea.com/sg/en/images/products/havsen-inset-sink-1-bowl-white__0865718_pe686262_s5.jpg?f=s" , 30 ));
//		productRepository.save(new Product( null, "Old School Vans" , 20, "Classic Vans BW " , "Footwear","https://png.pngitem.com/pimgs/s/680-6807721_vans-oldskool-shoes-sneakers-tumblr-trend-niche-popular.png" , 20 ));
//		productRepository.save(new Product( null, "Monopoly" , 20, "Card games" , "Games","https://w7.pngwing.com/pngs/521/166/png-transparent-monopoly-deal-monopoly-plus-monopoly-junior-hasbro-monopoly-monopoly-man-game-text-logo-thumbnail.png" , 15 ));
//		productRepository.save(new Product( null, "Curtain covers" , 20, "Orange-brown curtains" , "Lifestyle","https://www.ikea.com/sg/en/images/products/bengta-block-out-curtain-1-length__1056519_pe848368_s5.jpg?f=s" , 13 ));


	}
}


