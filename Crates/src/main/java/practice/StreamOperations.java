package practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperations {
    private static final Logger logger = LoggerFactory.getLogger(StreamOperations.class);

    public static void main(String[] args) {
        class Ball {
            private String type;
            private String name;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        Ball ball;
        List<Ball> list = new ArrayList<>();
        ball = new Ball();
        ball.setType("1");
        ball.setName("a");
        list.add(ball);

        ball = new Ball();
        ball.setType("1");
        ball.setName("b");
        list.add(ball);

        ball = new Ball();
        ball.setType("1");
        ball.setName("c");
        list.add(ball);

        ball = new Ball();
        ball.setType("2");
        ball.setName("d");
        list.add(ball);

        ball = new Ball();
        ball.setType("3");
        ball.setName("e");
        list.add(ball);

        Map<String, String> result = list.stream().collect(Collectors.toMap(Ball::getType, Ball::getName,
                                                            (v1, v2) -> v1 + "," + v2));

        for (Map.Entry<String, String> entry : result.entrySet()) {
            logger.info("key = {}, value = {}", entry.getKey(), entry.getValue());
        }
        logger.info(result.toString());
    }

}
