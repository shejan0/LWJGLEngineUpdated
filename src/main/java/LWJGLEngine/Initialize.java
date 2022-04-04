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
public class Initialize {
	public ArrayList<Long> windows;
	public Initialize() {
		windows=new ArrayList<Long>();
	}
	public void initGLFWContext() {
		GLFWErrorCallback.createPrint(System.err).set();
		if(!glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW space");
		}
	}
	public long makeFullScreen(String windowTitle) { //only starts on Primary Monitor
		long monitor=glfwGetPrimaryMonitor();
		GLFWVidMode vidmode =glfwGetVideoMode(monitor);
		glfwDefaultWindowHints();
		long window=glfwCreateWindow(vidmode.width(), vidmode.height(), windowTitle, monitor, NULL);
		glfwMakeContextCurrent(window);
		windows.add(window);
		
		return window;
		/*PointerBuffer monitors=glfwGetMonitors();
		System.out.println("Number of monitors:" +monitors.capacity());
		for(int n=0;n<monitors.capacity();n++) {
			System.out.println((n+1)+":");
			long monitor=monitors.get(n);
			GLFWVidMode vidmode =glfwGetVideoMode(monitor);
			int[] xpos,ypos,width,height;
			xpos = new int[1];
			ypos = new int[1];
			width = new int[1];
			height = new int[1];
			//glfwGetMonitorWorkarea
			glfwGetMonitorWorkarea(monitor, xpos, ypos, width, height);
			if(monitor==primaryMonitor) {
				System.out.println("PRIMARY MONITOR");
				glfwDefaultWindowHints();
				return glfwCreateWindow(width, height, windowTitle, monitor, share)
			}
			System.out.println("Monitor Name: "+glfwGetMonitorName(monitor));
			System.out.println("X,Y Size: "+vidmode.width()+","+vidmode.height());
			System.out.println("X,Y Pos: "+xpos[0]+","+ypos[0]);
			System.out.println("X,Y Workarea Size: "+width[0]+","+height[0]);
			System.out.println("R,G,B Bits: "+vidmode.redBits()+","+vidmode.greenBits()+","+vidmode.blueBits());
		}
		*/
	}
	public boolean InitializeKeyboardFunction(long window,Input input) {
		return glfwSetKeyCallback(window, (windowf, key, scancode, action, mods) ->{
			input.keyboard(windowf, key, scancode, action, mods);
		})!=null;
	}
	public boolean InitializeMouseButtonFunction(long window, Input input){
		return glfwSetMouseButtonCallback(window, (windowf,button,action,mods) ->{
				input.mousebutton(windowf,button,action,mods);
				})!=null;
	}
}
