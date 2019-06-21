import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * cli test
 * <pre>
 *     1. 直接浏览器输入 "http://localhost:8080/", 即可返回"Hello World!"
 *     2. app.groovy 可不放在boot 项目中, 可不import RestController RequestMapping 等依赖, spring cli 自动解析依赖并启动web 容器
 */
@RestController
class ThisWillActuallyRun {

	@RequestMapping("/")
	String home() {
		"Hello World!"
	}

}