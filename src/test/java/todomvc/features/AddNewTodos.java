package todomvc.features;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewTodos {

	@CastMember(name = "Toby")
	Actor toby;
	
	@Test
	@DisplayName("Add a todo item to an empty list")
	void addToEmptyList() {
		toby.attemptsTo(
				Open.url("https://todomvc/examples/angularjs/#/"),
				Enter.theValue("Buy some milk").into(".new-todo").thenHit(Keys.RETURN)				
				);
		
		var todos = toby.asksFor(Text.ofEach(".todo-list li"));
		assertThat(todos).containsExactly("Buy some milk");
	}
}
