package LWJGLEngine;
import org.joml.Random;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;
import java.util.*;
import java.lang.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
public class Renderer {
	long window;
	GLCapabilities capabilities;
	public Renderer(long wind) {
		window=wind;
		capabilities = GL.createCapabilities();
		setBackColor();
		
	}
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

		glfwSwapBuffers(window); // swap the color buffers

		// Poll for window events. The key callback above will only be
		// invoked during this call.
		glfwPollEvents();
	}
	public void setBackColor(){
		Random rand = new Random(System.nanoTime());
		setBackColor(rand.nextFloat(),rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
	}
	public void setBackColor(float r,float g,float b,float a) {
		glClearColor(r, g, b, a);
	}

}
