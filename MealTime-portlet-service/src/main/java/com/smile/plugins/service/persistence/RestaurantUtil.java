package com.smile.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.smile.plugins.model.Restaurant;

import java.util.List;

/**
 * The persistence utility for the restaurant service. This utility wraps {@link RestaurantPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaume Lenoir
 * @see RestaurantPersistence
 * @see RestaurantPersistenceImpl
 * @generated
 */
public class RestaurantUtil {
    private static RestaurantPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Restaurant restaurant) {
        getPersistence().clearCache(restaurant);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Restaurant> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Restaurant> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Restaurant> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Restaurant update(Restaurant restaurant)
        throws SystemException {
        return getPersistence().update(restaurant);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Restaurant update(Restaurant restaurant,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(restaurant, serviceContext);
    }

    /**
    * Returns all the restaurants where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the restaurants where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @return the range of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the restaurants where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first restaurant in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first restaurant in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last restaurant in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last restaurant in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the restaurants before and after the current restaurant in the ordered set where uuid = &#63;.
    *
    * @param restaurantId the primary key of the current restaurant
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant[] findByUuid_PrevAndNext(
        long restaurantId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence()
                   .findByUuid_PrevAndNext(restaurantId, uuid, orderByComparator);
    }

    /**
    * Removes all the restaurants where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of restaurants where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the restaurant where uuid = &#63; and groupId = &#63; or throws a {@link com.smile.plugins.NoSuchRestaurantException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the restaurant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the restaurant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the restaurant where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the restaurant that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of restaurants where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the restaurants where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the restaurants where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @return the range of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the restaurants where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first restaurant in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first restaurant in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last restaurant in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last restaurant in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the restaurants before and after the current restaurant in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param restaurantId the primary key of the current restaurant
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant[] findByUuid_C_PrevAndNext(
        long restaurantId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(restaurantId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the restaurants where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of restaurants where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the restaurants where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the restaurants where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @return the range of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the restaurants where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first restaurant in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first restaurant in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last restaurant in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last restaurant in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the restaurants before and after the current restaurant in the ordered set where groupId = &#63;.
    *
    * @param restaurantId the primary key of the current restaurant
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant[] findByGroupId_PrevAndNext(
        long restaurantId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(restaurantId, groupId,
            orderByComparator);
    }

    /**
    * Returns all the restaurants that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching restaurants that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId);
    }

    /**
    * Returns a range of all the restaurants that the user has permission to view where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @return the range of matching restaurants that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the restaurants that the user has permissions to view where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching restaurants that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the restaurants before and after the current restaurant in the ordered set of restaurants that the user has permission to view where groupId = &#63;.
    *
    * @param restaurantId the primary key of the current restaurant
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant[] filterFindByGroupId_PrevAndNext(
        long restaurantId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence()
                   .filterFindByGroupId_PrevAndNext(restaurantId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the restaurants where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of restaurants where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of restaurants that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching restaurants that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByGroupId(groupId);
    }

    /**
    * Caches the restaurant in the entity cache if it is enabled.
    *
    * @param restaurant the restaurant
    */
    public static void cacheResult(
        com.smile.plugins.model.Restaurant restaurant) {
        getPersistence().cacheResult(restaurant);
    }

    /**
    * Caches the restaurants in the entity cache if it is enabled.
    *
    * @param restaurants the restaurants
    */
    public static void cacheResult(
        java.util.List<com.smile.plugins.model.Restaurant> restaurants) {
        getPersistence().cacheResult(restaurants);
    }

    /**
    * Creates a new restaurant with the primary key. Does not add the restaurant to the database.
    *
    * @param restaurantId the primary key for the new restaurant
    * @return the new restaurant
    */
    public static com.smile.plugins.model.Restaurant create(long restaurantId) {
        return getPersistence().create(restaurantId);
    }

    /**
    * Removes the restaurant with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param restaurantId the primary key of the restaurant
    * @return the restaurant that was removed
    * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant remove(long restaurantId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence().remove(restaurantId);
    }

    public static com.smile.plugins.model.Restaurant updateImpl(
        com.smile.plugins.model.Restaurant restaurant)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(restaurant);
    }

    /**
    * Returns the restaurant with the primary key or throws a {@link com.smile.plugins.NoSuchRestaurantException} if it could not be found.
    *
    * @param restaurantId the primary key of the restaurant
    * @return the restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant findByPrimaryKey(
        long restaurantId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException {
        return getPersistence().findByPrimaryKey(restaurantId);
    }

    /**
    * Returns the restaurant with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param restaurantId the primary key of the restaurant
    * @return the restaurant, or <code>null</code> if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.smile.plugins.model.Restaurant fetchByPrimaryKey(
        long restaurantId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(restaurantId);
    }

    /**
    * Returns all the restaurants.
    *
    * @return the restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the restaurants.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @return the range of restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the restaurants.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.smile.plugins.model.impl.RestaurantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of restaurants
    * @param end the upper bound of the range of restaurants (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of restaurants
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.smile.plugins.model.Restaurant> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the restaurants from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of restaurants.
    *
    * @return the number of restaurants
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RestaurantPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RestaurantPersistence) PortletBeanLocatorUtil.locate(com.smile.plugins.service.ClpSerializer.getServletContextName(),
                    RestaurantPersistence.class.getName());

            ReferenceRegistry.registerReference(RestaurantUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(RestaurantPersistence persistence) {
    }
}
