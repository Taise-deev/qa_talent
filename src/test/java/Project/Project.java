package Project;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Project {

    private WebDriver driver;
    private WebDriverWait wait;

  //estou usando FindBy para guardar os elementos.
    @FindBy(css = ".login")
    private WebElement btnLogin;

    @FindBy(id = "email_create")
    private WebElement inputEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement btnCriar;

    @FindBy(id = "uniform-id_gender2")
    private WebElement radioTitle;

    @FindBy(id = "customer_firstname")
    private WebElement nome;

    @FindBy(id = "customer_lastname")
    private WebElement sobrenome;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement diaNascimento;

    @FindBy(id = "months")
    private WebElement mesNascimento;

    @FindBy(id = "years")
    private WebElement anoNascimento;

    @FindBy(id = "uniform-optin")
    private WebElement selecionar;

    @FindBy(id = "firstname")
    private WebElement nomeEndereco;

    @FindBy(id = "lastname")
    private WebElement sobrenomeEndereco;

    @FindBy(id = "address1")
    private WebElement endereco;

    @FindBy(id = "city")
    private WebElement cidade;

    @FindBy(id = "id_state")
    private WebElement estado;

    @FindBy(id = "postcode")
    private WebElement cep;

    @FindBy(id = "id_country")
    private WebElement pais;

    @FindBy(id = "phone_mobile")
    private WebElement celular;

    @FindBy(id = "submitAccount")
    private WebElement btnregistro;

    @FindBy(xpath = "//p[contains(text(),'Welcome to your account.')]")
    private WebElement minhaConta;

// utilizando uma variavel que recebe uma string aleatória.
   public  String textoAleatorio = UUID.randomUUID().toString().substring(0, 6);

    //no before esta inicializando o chrome e fazendo a configuração da tela.
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tialison\\Desktop\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
// dentro do test estou realizando ações para preencher todos os campos obrigatórios, utilizando os próprios métodos do selenium.
    @Test
    public void criarLogin() {
        btnLogin.click();

        inputEmail.sendKeys(textoAleatorio + "@test.com");

        btnCriar.click();

        radioTitle.click();

        nome.sendKeys("Taise");

        sobrenome.sendKeys("Silva");

        password.sendKeys("123456");

        Select select = new Select(diaNascimento);
        select.selectByValue("1");

        Select select1 = new Select(mesNascimento);
        select1.selectByValue("1");

        Select select2 = new Select(anoNascimento);
        select2.selectByValue("1998");

        selecionar.click();

        nomeEndereco.sendKeys("Taise");

        sobrenomeEndereco.sendKeys("Silva");

        endereco.sendKeys("735 Anacapa Street");

        cidade.sendKeys("Santa Barbara");

        Select select3 = new Select(estado);
        select3.selectByValue("5");

        cep.sendKeys("93101");

        Select select4 = new Select(pais);
        select4.selectByValue("21");

        celular.sendKeys("989736394");

        btnregistro.click();

        String texto = minhaConta.getText().substring(0, 24);

        Assert.assertEquals(texto, "Welcome to your account.");
    }
//  após a realização do test o After fecha o meu broswer.
    @After
    public void fecharBroswer() {
        driver.quit();
    }
}
