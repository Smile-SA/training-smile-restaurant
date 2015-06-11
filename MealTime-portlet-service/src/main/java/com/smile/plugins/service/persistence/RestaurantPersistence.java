package com.smile.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.smile.plugins.model.Restaurant;

/**
 * The persistence interface for the restaurant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaume Lenoir
 * @see RestaurantPersistenceImpl
 * @see RestaurantUtil
 * @generated
 */
public interface RestaurantPersistence extends BasePersistence<Restaurant> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RestaurantUtil} to access the restaurant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the restaurants where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.smile.plugins.model.Restaurant> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first restaurant in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the first restaurant in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last restaurant in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the last restaurant in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.smile.plugins.model.Restaurant[] findByUuid_PrevAndNext(
        long restaurantId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Removes all the restaurants where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of restaurants where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the restaurant where uuid = &#63; and groupId = &#63; or throws a {@link com.smile.plugins.NoSuchRestaurantException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the restaurant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the restaurant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the restaurant where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the restaurant that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the number of restaurants where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the restaurants where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.smile.plugins.model.Restaurant> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.smile.plugins.model.Restaurant findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the first restaurant in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.smile.plugins.model.Restaurant findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the last restaurant in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.smile.plugins.model.Restaurant[] findByUuid_C_PrevAndNext(
        long restaurantId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Removes all the restaurants where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of restaurants where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the restaurants where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.smile.plugins.model.Restaurant> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first restaurant in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the first restaurant in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last restaurant in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant findByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the last restaurant in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching restaurant, or <code>null</code> if a matching restaurant could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.smile.plugins.model.Restaurant[] findByGroupId_PrevAndNext(
        long restaurantId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns all the restaurants that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching restaurants that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.smile.plugins.model.Restaurant> filterFindByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> filterFindByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> filterFindByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.smile.plugins.model.Restaurant[] filterFindByGroupId_PrevAndNext(
        long restaurantId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Removes all the restaurants where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of restaurants where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching restaurants
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of restaurants that the user has permission to view where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching restaurants that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the restaurant in the entity cache if it is enabled.
    *
    * @param restaurant the restaurant
    */
    public void cacheResult(com.smile.plugins.model.Restaurant restaurant);

    /**
    * Caches the restaurants in the entity cache if it is enabled.
    *
    * @param restaurants the restaurants
    */
    public void cacheResult(
        java.util.List<com.smile.plugins.model.Restaurant> restaurants);

    /**
    * Creates a new restaurant with the primary key. Does not add the restaurant to the database.
    *
    * @param restaurantId the primary key for the new restaurant
    * @return the new restaurant
    */
    public com.smile.plugins.model.Restaurant create(long restaurantId);

    /**
    * Removes the restaurant with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param restaurantId the primary key of the restaurant
    * @return the restaurant that was removed
    * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant remove(long restaurantId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    public com.smile.plugins.model.Restaurant updateImpl(
        com.smile.plugins.model.Restaurant restaurant)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the restaurant with the primary key or throws a {@link com.smile.plugins.NoSuchRestaurantException} if it could not be found.
    *
    * @param restaurantId the primary key of the restaurant
    * @return the restaurant
    * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant findByPrimaryKey(
        long restaurantId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.smile.plugins.NoSuchRestaurantException;

    /**
    * Returns the restaurant with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param restaurantId the primary key of the restaurant
    * @return the restaurant, or <code>null</code> if a restaurant with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.smile.plugins.model.Restaurant fetchByPrimaryKey(
        long restaurantId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the restaurants.
    *
    * @return the restaurants
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.smile.plugins.model.Restaurant> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.smile.plugins.model.Restaurant> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the restaurants from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of restaurants.
    *
    * @return the number of restaurants
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
