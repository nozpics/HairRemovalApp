package com.example.hairremoval;


import com.example.hairremoval.utils.MessageUtils;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@SpringBootApplication
public class HairRemovalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HairRemovalAppApplication.class, args);
	}
	/**
	 * LogFilterの設定
	 * @return
	 */
//	@Bean
//	public FilterRegistrationBean logFilter(){
//		//フィルタのオブジェクトを1番目に実行するフィルタとして追加
//		FilterRegistrationBean bean = new FilterRegistrationBean(new RestApiLoggingFilter());
//		//コントローラ・静的コンテンツ全てのリクエストに対してフィルタを有効化
//		bean.addUrlPatterns("/api/*");
//		//フィルタの実行順序を1に設定
//		bean.setOrder(1);
//		return bean;
//	}

	/**
	 * データソース Application.ymlに接続文字列を記載
	 * @return
	 */
	@Bean(name = "dataSource")
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource(){
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	/**
	 * トランザクションマネージャー
	 * @return
	 */
	@Bean(name = "datasourcemanager")
	public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource")DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * MessageUtilsの初期化
	 *
	 * @return MessageUtils
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.messages")
	public MessageUtils messageUtils(MessageSource messageSource){
		return new MessageUtils(messageSource);
	}

}
