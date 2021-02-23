package leetcodewrite.circulardependency.springloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author : liguo
 * @Description : spring 循环依赖
 * @data : 2020/12/16
 */
@Component
public class LoopBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoopBean.class);
        SpringB bean = context.getBean(SpringB.class);
        System.out.println();
    }

    @Component("springA")
    public class SpringA {
        @Autowired
        @Qualifier("springB")
        private SpringB springB;

        public SpringB getSpringB() {
            return springB;
        }

        public void setSpringB(SpringB springB) {
            this.springB = springB;
        }
    }

    @Component("springB")
    public class SpringB {
        @Autowired
        @Qualifier("springA")
        private SpringA springA;

        public SpringA getSpringA() {
            return springA;
        }

        public void setSpringA(SpringA springA) {
            this.springA = springA;
        }
    }
}

