package org.oreon.core.gl.deferred;

import static org.lwjgl.opengl.GL11.GL_DEPTH_COMPONENT;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL30.GL_RGBA16F;
import static org.lwjgl.opengl.GL11.GL_RED;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL30.GL_DEPTH_COMPONENT32F;
import static org.lwjgl.opengl.GL30.GL_R16F;

import java.nio.ByteBuffer;

import org.oreon.core.gl.texture.Texture2D;

public class TransparencyGBuffer {

	private Texture2D albedoTexture;
	private Texture2D alphaTexture;
	private Texture2D lightScatteringMask;
	private Texture2D depthTexture;
	
	public TransparencyGBuffer(int width, int height) {
	
		albedoTexture = new Texture2D();
		albedoTexture.generate();
		albedoTexture.bind();
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA16F, width, height, 0, GL_RGBA, GL_FLOAT, (ByteBuffer) null);
		albedoTexture.noFilter();
		
		alphaTexture = new Texture2D();
		alphaTexture.generate();
		alphaTexture.bind();
		glTexImage2D(GL_TEXTURE_2D, 0, GL_R16F, width, height, 0, GL_RED, GL_FLOAT, (ByteBuffer) null);
		alphaTexture.noFilter();
		
		lightScatteringMask = new Texture2D();
		lightScatteringMask.generate();
		lightScatteringMask.bind();
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA16F, width, height, 0, GL_RGBA, GL_FLOAT, (ByteBuffer) null);
		lightScatteringMask.noFilter();
		
		depthTexture = new Texture2D();
		depthTexture.generate();
		depthTexture.bind();
		glTexImage2D(GL_TEXTURE_2D, 0, GL_DEPTH_COMPONENT32F, width, height, 0, GL_DEPTH_COMPONENT, GL_FLOAT, (ByteBuffer) null);
		depthTexture.noFilter();
	}

	public Texture2D getAlbedoTexture() {
		return albedoTexture;
	}

	public void setAlbedoTexture(Texture2D albedoTexture) {
		this.albedoTexture = albedoTexture;
	}

	public Texture2D getAlphaTexture() {
		return alphaTexture;
	}

	public void setAlphaTexture(Texture2D alphaTexture) {
		this.alphaTexture = alphaTexture;
	}

	public Texture2D getDepthTexture() {
		return depthTexture;
	}

	public void setDepthTexture(Texture2D depthTexture) {
		this.depthTexture = depthTexture;
	}

	public Texture2D getLightScatteringMask() {
		return lightScatteringMask;
	}

	public void setLightScatteringMask(Texture2D lightScatteringMask) {
		this.lightScatteringMask = lightScatteringMask;
	}
}
