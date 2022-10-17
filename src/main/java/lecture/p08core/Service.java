package lecture.p08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class Service {
	@Autowired
	@Getter
	@Setter
	Controller cont;
}
