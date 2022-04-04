package LWJGLEngine;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;
import java.util.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
public class Engine {
	Initialize context;
	Input input;
	Renderer renderer;
	GObject scene;
	public Engine() {
		context = new Initialize();
		input = new Input();
		scene=new GObject();
		Start();
	}
	public void Start() {
		context.initGLFWContext();
		long window =context.makeFullScreen("Shejan's LWJGL Engine");
		renderer = new Renderer(window);
		context.InitializeKeyboardFunction(window, input);
		context.InitializeMouseButtonFunction(window,input);
	}
	public void run() {
		long window = context.windows.get(0);
		while ( !glfwWindowShouldClose(window) ) {
			renderer.render();
		}
	}
	public static String generateRandString(int length) {
		Random rand=new Random(System.nanoTime());
		return rand.ints(48, 123)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(length)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	}
}
