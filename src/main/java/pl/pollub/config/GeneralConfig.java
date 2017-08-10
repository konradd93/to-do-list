package pl.pollub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import pl.pollub.model.project.Project;
import pl.pollub.model.task.Task;
import pl.pollub.model.team.Team;
import pl.pollub.model.user.User;
import pl.pollub.service.EmailNotifier;

import javax.sql.DataSource;

@Configuration
public class GeneralConfig {

        @Autowired
        @Qualifier("dataSource")
        DataSource dataSource;

        @Bean(name = "sessionFactory")
        public LocalSessionFactoryBean hibernate5SessionFactoryBean() {
            LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
            localSessionFactoryBean.setDataSource(dataSource);
            localSessionFactoryBean.setAnnotatedClasses(
                    Task.class,
                    User.class,
                    Project.class,
                    Team.class,
                    EmailNotifier.class
            );

            return localSessionFactoryBean;
        }
}

