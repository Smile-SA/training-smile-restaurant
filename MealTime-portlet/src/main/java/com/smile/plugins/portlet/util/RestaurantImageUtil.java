
package com.smile.plugins.portlet.util;

import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class
 * Resize images.
 *
 */
public class RestaurantImageUtil {
	
	/**
	 * Max image height for the resizing process 
	 */
	public static final int IMAGE_MAX_HEIGHT = 300;

	/**
	 * Max image width for the resizing process 
	 */
	public static final int IMAGE_MAX_WIDTH = 300;
	

	/**
	 * ProspectImageUtil Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RestaurantImageUtil.class);

	/**
	 * 
	 */
	private RestaurantImageUtil() {

		super();
	}

	/**
	 * resize Images
	 * 
	 * @param inputStream
	 */
	public static InputStream resizeImages(InputStream inputStream) {

		RenderedImage renderedImage = null;
		ImageBag imageBag = null;
		byte[] bitsTab = null;
		ByteArrayFileInputStream byteFileInputStream = (ByteArrayFileInputStream) inputStream;

		if (byteFileInputStream != null && byteFileInputStream.getFile() != null) {
			try {
				File file = byteFileInputStream.getFile();
				imageBag = ImageToolUtil.read(byteFileInputStream);
				renderedImage = imageBag.getRenderedImage();

				renderedImage = ImageToolUtil.scale(renderedImage, IMAGE_MAX_HEIGHT, IMAGE_MAX_WIDTH);
				bitsTab = ImageToolUtil.getBytes(renderedImage, imageBag.getType());

				FileOutputStream tmpOutputStream = null;
				try {
					tmpOutputStream = new FileOutputStream(file);
					tmpOutputStream.write(bitsTab);
					byteFileInputStream = new ByteArrayFileInputStream(file, 1024, true);
				}
				catch (FileNotFoundException e) {
					LOGGER.error("FileNotFoundException: " + e);
				}
				catch (IOException e) {
					LOGGER.error("IOException: " + e);
				}
				finally {
					if (tmpOutputStream != null)
						try {
							tmpOutputStream.close();
						}
						catch (IOException e) {
							LOGGER.error("IOException: " + e);
						}
				}
			}
			catch (Exception e) {// NOSONAR ( traitement non bloquant )
				LOGGER.error("Exception unable to resize Image");
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
			}
		}

		return byteFileInputStream;
	}

	/**
	 * Get the extension of a file.
	 * 
	 * @param file
	 *            file
	 * @return file extension
	 */
	public static String getExtension(File file) {

		String ext = null;
		String s = file.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}

		return ext;
	}

}
