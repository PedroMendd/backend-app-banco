package me.dio.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id") // Mapeia a chave estrangeira
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id") // Mapeia a chave estrangeira
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_features", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "user_id"), // Chave estrangeira na tabela de junção apontando para User
            inverseJoinColumns = @JoinColumn(name = "feature_id") // Chave estrangeira na tabela de junção apontando para Feature
    )
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_news", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "user_id"), // Chave estrangeira na tabela de junção apontando para User
            inverseJoinColumns = @JoinColumn(name = "news_id") // Chave estrangeira na tabela de junção apontando para News
    )
    private List<News> news;
}

