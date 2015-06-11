package com.smile.plugins.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Restaurant service. Represents a row in the &quot;MealTime_Restaurant&quot; database table, with each column mapped to a property of this class.
 *
 * @author guillaume Lenoir
 * @see RestaurantModel
 * @see com.smile.plugins.model.impl.RestaurantImpl
 * @see com.smile.plugins.model.impl.RestaurantModelImpl
 * @generated
 */
public interface Restaurant extends RestaurantModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.smile.plugins.model.impl.RestaurantImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.io.InputStream getLogoInputStream();

    public void setLogoInputStream(java.io.InputStream logoInputStream);

    public java.lang.String getStatus(java.util.Locale locale);

    public java.lang.String getRegion();

    public java.lang.String getCountry(java.util.Locale locale);

    public java.lang.String getLogoSrc(
        com.liferay.portal.theme.ThemeDisplay themeDisplay);
}
