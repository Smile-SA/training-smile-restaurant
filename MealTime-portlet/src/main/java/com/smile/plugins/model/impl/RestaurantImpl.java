package com.smile.plugins.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.util.DLUtil;

import java.io.InputStream;
import java.util.Locale;

/**
 * The extended model implementation for the Restaurant service. Represents a row in the &quot;MealTime_Restaurant&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.smile.plugins.model.Restaurant} interface.
 * </p>
 *
 * @author guillaume Lenoir
 */
public class RestaurantImpl extends RestaurantBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a restaurant model instance should use the {@link com.smile.plugins.model.Restaurant} interface instead.
     */
    public RestaurantImpl() {
    }
    
    /**
     * Inputstream Logo
     */
    private InputStream logoInputStream;
	
	public InputStream getLogoInputStream() {
	
		return logoInputStream;
	}

	public void setLogoInputStream(InputStream logoInputStream) {
	
		this.logoInputStream = logoInputStream;
	}

	/**
	 * AnnouncementImpl Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RestaurantImpl.class);
    
	public String getStatus(Locale locale) {
		return LanguageUtil.get(locale, WorkflowConstants.getStatusLabel(getStatus())) ;
	}
	
	public String getRegion() {
		long regionId = getRegionId();
		String regionName = StringPool.BLANK;
		
		if (Validator.isNotNull(regionId)) {
			Region region = null;
			try {
				region = RegionServiceUtil.getRegion(regionId);
				if (Validator.isNotNull(region)) {
					regionName = region.getName();
				}
			}
			catch (PortalException pe) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(pe);
				}
				LOGGER.error("PortalException : impossible to get region " + regionId);
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("SystemException : impossible to get region " + regionId);
			}
		}
		return regionName;
	}
	
	public String getCountry(Locale locale) {
		long countryId = getCountryId();
		String countryName = StringPool.BLANK;
		
		if (Validator.isNotNull(countryId)) {
			Country country = null;
			try {
				country = CountryServiceUtil.getCountry(countryId);
			}
			catch (PortalException pe) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(pe);
				}
				LOGGER.error("PortalException : impossible to get country " + countryId);
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("SystemException : impossible to get country " + countryId);
			}
			if (Validator.isNotNull(country)) {
				countryName = country.getName(locale);
			}
		}
		return countryName;
	}
	
	public String getLogoSrc(ThemeDisplay themeDisplay) {
		String url = StringPool.BLANK;

		FileEntry fileEntry = null;
		if (Validator.isNotNull(this.getLogoId())) {
			try {
				fileEntry = PortletFileRepositoryUtil.getPortletFileEntry(this.getLogoId());
				
				url = DLUtil.getPreviewURL(
					fileEntry, fileEntry.getLatestFileVersion(), themeDisplay,
					StringPool.BLANK);
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("PortalException : impossible to get logo for " + this.getLogoId());
			}
			catch (SystemException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("PortalException : impossible to get logo for " + this.getLogoId());
			}
		}
				
		return url;
	}

}
