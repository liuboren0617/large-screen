package com.qax.dayu.large.screen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * .
 * Largescreen。
 *  @author lbr
 */
@SpringBootApplication
public class LargescreenApplication {


    /*
     * 数据聚合API
     * */
    @Bean
    public Function<Flux<String>, Flux<String>> polymerization() {
        // 1. 参数为url 、过滤条件

        // 2. 调用httpClient 查询数据

        // 3. 返回数据

        return flux -> flux.map(value -> value.toLowerCase());
    }


    /*
    * api查询Function, 透传时使用
    * */
    @Bean
    public Function<Flux<String>, Flux<String>> findAPI() {
        // 1. 参数为方法名、过滤条件

        // 2. 调用httpClient 查询数据

        // 3. 返回数据




        //return flux -> list;

         return flux -> {
             // 查询漏洞知识库数据
             int num1 = 265;
             // 查询威胁情报数据
             int num2 = 333;
             // 查询IP位置库
             int num3 = 666;
             // 聚合数据并返回
             List<Integer> list = new ArrayList<>();
             list.add(num1);
             list.add(num2);
             list.add(num3);
             return flux.map(value -> value.toLowerCase());
         };
    }


    /*
    * 过滤函数, 将数据从大到小排序
    * */
    @Bean
    public Function<List<Integer>,List<Integer>> sort(){
        return list -> {
            list.sort(Comparator.comparing(Integer::intValue));
            return list;
        };
    }






    /*
    * 云端知识库查询
    * */
    @Bean
    public Function<Flux<String>, List<Integer>> findAllCloudKnowledgeBase() {

        return flux -> {
            // 查询对应的数据进行聚合并返回
            flux.map(value -> {
                System.out.println("value = " + value);
                return null;
            });
            // 查询漏洞知识库数据
            int num1 = 265;
            // 查询威胁情报数据
            int num2 = 333;
            // 查询`IP位置库
            int num3 = 666;
            // 聚合数据并返回
            List<Integer> list = new ArrayList<>();
            list.add(num1);
            list.add(num2);
            list.add(num3);

            return list;
        };
    }



    public static void main(final String[] args) {
        SpringApplication.run(LargescreenApplication.class, args);
    }
}
