import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSelenium extends Base {

    @Test
    void testWikipedia()  {
        String url = "https://www.google.com/";
        String busquedaObjetivo = "Hola Mundo";

        driver.get(url);
        WebElement busqueda = driver.findElement(By.xpath("//textarea[@name='q']"));
        busqueda.click();
        busqueda.sendKeys("Wikipeda");
        busqueda.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//h3/..")).click(); // h3 son los todos los resultados y accedo al padre porqe es la etiqueta <a> que tiene el link

        WebElement busquedaWikipeda = driver.findElement(By.name("search"));
        busquedaWikipeda.click();
        busquedaWikipeda.sendKeys(busquedaObjetivo);
        driver.findElement(By.cssSelector("#searchform button")).click();

        String resultado = driver.findElement(By.id("firstHeading")).getText();
        assertEquals("Hola mundo", resultado);

    }

    @Test
    void testCapacitaciones() {
        String url = "https://capacitacion.ces.com.uy";
        String usuario  = "";
        String password = "";

        driver.get(url);
        driver.findElement(By.xpath("//a[contains(., 'Acceder')]")).click();
        driver.findElement(By.id("username")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginbtn")).click();

        driver.findElement(By.xpath("//a[contains(., 'TALLER DE AUTOMATIZACIÓN')]")).click();
        driver.findElement(By.xpath("//a[contains(., 'Foros')]")).click();
        WebElement busqueda = driver.findElement(By.name("search"));
        busqueda.click();
        busqueda.sendKeys("Bienvenida");
        busqueda.sendKeys(Keys.ENTER);

        String resultado = driver.findElement(By.xpath("//h3[contains(.,'Resultado')]")).getText();
        assertTrue(resultado.contains("1"));
    }



}
