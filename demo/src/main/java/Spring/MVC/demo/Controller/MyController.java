package Spring.MVC.demo.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/test")
    public Users test(){
        return new Users(1,"Varad");
    }

    @PostMapping("/getName/{id}")
    public String getName(@PathVariable int id){
        return "Varad" + id;
    }

    @PostMapping("/getAge")
    public ResponseEntity<String> getAge(@RequestParam int id){
        String a  = "Varad " + id;
        return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
    }

    @PostMapping("/getuser")
    public ResponseEntity<Users> getuser(@RequestBody Users user){
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
class Users{
    int age;
    String name;

    public Users(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


//So Spring is using dispatch servket to map url to Rest controller
//At the test url we are returning java object but due to Jackson and HTTPMessageConverter the java
// object is getting converted to JSON
