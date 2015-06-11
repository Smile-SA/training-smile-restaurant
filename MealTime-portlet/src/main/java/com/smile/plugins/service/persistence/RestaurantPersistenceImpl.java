package com.smile.plugins.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.smile.plugins.NoSuchRestaurantException;
import com.smile.plugins.model.Restaurant;
import com.smile.plugins.model.impl.RestaurantImpl;
import com.smile.plugins.model.impl.RestaurantModelImpl;
import com.smile.plugins.service.persistence.RestaurantPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the restaurant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaume Lenoir
 * @see RestaurantPersistence
 * @see RestaurantUtil
 * @generated
 */
public class RestaurantPersistenceImpl extends BasePersistenceImpl<Restaurant>
    implements RestaurantPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RestaurantUtil} to access the restaurant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RestaurantImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            RestaurantModelImpl.UUID_COLUMN_BITMASK |
            RestaurantModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "restaurant.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "restaurant.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(restaurant.uuid IS NULL OR restaurant.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            RestaurantModelImpl.UUID_COLUMN_BITMASK |
            RestaurantModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "restaurant.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "restaurant.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(restaurant.uuid IS NULL OR restaurant.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "restaurant.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            RestaurantModelImpl.UUID_COLUMN_BITMASK |
            RestaurantModelImpl.COMPANYID_COLUMN_BITMASK |
            RestaurantModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "restaurant.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "restaurant.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(restaurant.uuid IS NULL OR restaurant.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "restaurant.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, RestaurantImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            RestaurantModelImpl.GROUPID_COLUMN_BITMASK |
            RestaurantModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "restaurant.groupId = ?";
    private static final String _SQL_SELECT_RESTAURANT = "SELECT restaurant FROM Restaurant restaurant";
    private static final String _SQL_SELECT_RESTAURANT_WHERE = "SELECT restaurant FROM Restaurant restaurant WHERE ";
    private static final String _SQL_COUNT_RESTAURANT = "SELECT COUNT(restaurant) FROM Restaurant restaurant";
    private static final String _SQL_COUNT_RESTAURANT_WHERE = "SELECT COUNT(restaurant) FROM Restaurant restaurant WHERE ";
    private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "restaurant.restaurantId";
    private static final String _FILTER_SQL_SELECT_RESTAURANT_WHERE = "SELECT DISTINCT {restaurant.*} FROM MealTime_Restaurant restaurant WHERE ";
    private static final String _FILTER_SQL_SELECT_RESTAURANT_NO_INLINE_DISTINCT_WHERE_1 =
        "SELECT {MealTime_Restaurant.*} FROM (SELECT DISTINCT restaurant.restaurantId FROM MealTime_Restaurant restaurant WHERE ";
    private static final String _FILTER_SQL_SELECT_RESTAURANT_NO_INLINE_DISTINCT_WHERE_2 =
        ") TEMP_TABLE INNER JOIN MealTime_Restaurant ON TEMP_TABLE.restaurantId = MealTime_Restaurant.restaurantId";
    private static final String _FILTER_SQL_COUNT_RESTAURANT_WHERE = "SELECT COUNT(DISTINCT restaurant.restaurantId) AS COUNT_VALUE FROM MealTime_Restaurant restaurant WHERE ";
    private static final String _FILTER_ENTITY_ALIAS = "restaurant";
    private static final String _FILTER_ENTITY_TABLE = "MealTime_Restaurant";
    private static final String _ORDER_BY_ENTITY_ALIAS = "restaurant.";
    private static final String _ORDER_BY_ENTITY_TABLE = "MealTime_Restaurant.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Restaurant exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Restaurant exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RestaurantPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Restaurant _nullRestaurant = new RestaurantImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Restaurant> toCacheModel() {
                return _nullRestaurantCacheModel;
            }
        };

    private static CacheModel<Restaurant> _nullRestaurantCacheModel = new CacheModel<Restaurant>() {
            @Override
            public Restaurant toEntityModel() {
                return _nullRestaurant;
            }
        };

    public RestaurantPersistenceImpl() {
        setModelClass(Restaurant.class);
    }

    /**
     * Returns all the restaurants where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Restaurant> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Restaurant> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    @Override
    public List<Restaurant> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Restaurant> list = (List<Restaurant>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Restaurant restaurant : list) {
                if (!Validator.equals(uuid, restaurant.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_RESTAURANT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RestaurantModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Restaurant>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Restaurant>(list);
                } else {
                    list = (List<Restaurant>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Restaurant findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = fetchByUuid_First(uuid, orderByComparator);

        if (restaurant != null) {
            return restaurant;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRestaurantException(msg.toString());
    }

    /**
     * Returns the first restaurant in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching restaurant, or <code>null</code> if a matching restaurant could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Restaurant> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Restaurant findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = fetchByUuid_Last(uuid, orderByComparator);

        if (restaurant != null) {
            return restaurant;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRestaurantException(msg.toString());
    }

    /**
     * Returns the last restaurant in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching restaurant, or <code>null</code> if a matching restaurant could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Restaurant> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Restaurant[] findByUuid_PrevAndNext(long restaurantId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = findByPrimaryKey(restaurantId);

        Session session = null;

        try {
            session = openSession();

            Restaurant[] array = new RestaurantImpl[3];

            array[0] = getByUuid_PrevAndNext(session, restaurant, uuid,
                    orderByComparator, true);

            array[1] = restaurant;

            array[2] = getByUuid_PrevAndNext(session, restaurant, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Restaurant getByUuid_PrevAndNext(Session session,
        Restaurant restaurant, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RESTAURANT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RestaurantModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(restaurant);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Restaurant> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the restaurants where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Restaurant restaurant : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(restaurant);
        }
    }

    /**
     * Returns the number of restaurants where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_RESTAURANT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public Restaurant findByUUID_G(String uuid, long groupId)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = fetchByUUID_G(uuid, groupId);

        if (restaurant == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRestaurantException(msg.toString());
        }

        return restaurant;
    }

    /**
     * Returns the restaurant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching restaurant, or <code>null</code> if a matching restaurant could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    @Override
    public Restaurant fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Restaurant) {
            Restaurant restaurant = (Restaurant) result;

            if (!Validator.equals(uuid, restaurant.getUuid()) ||
                    (groupId != restaurant.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_RESTAURANT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Restaurant> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Restaurant restaurant = list.get(0);

                    result = restaurant;

                    cacheResult(restaurant);

                    if ((restaurant.getUuid() == null) ||
                            !restaurant.getUuid().equals(uuid) ||
                            (restaurant.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, restaurant);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Restaurant) result;
        }
    }

    /**
     * Removes the restaurant where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the restaurant that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant removeByUUID_G(String uuid, long groupId)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = findByUUID_G(uuid, groupId);

        return remove(restaurant);
    }

    /**
     * Returns the number of restaurants where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_RESTAURANT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the restaurants where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Restaurant> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Restaurant> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
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
    @Override
    public List<Restaurant> findByUuid_C(String uuid, long companyId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Restaurant> list = (List<Restaurant>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Restaurant restaurant : list) {
                if (!Validator.equals(uuid, restaurant.getUuid()) ||
                        (companyId != restaurant.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_RESTAURANT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RestaurantModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Restaurant>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Restaurant>(list);
                } else {
                    list = (List<Restaurant>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Restaurant findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (restaurant != null) {
            return restaurant;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRestaurantException(msg.toString());
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
    @Override
    public Restaurant fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Restaurant> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Restaurant findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (restaurant != null) {
            return restaurant;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRestaurantException(msg.toString());
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
    @Override
    public Restaurant fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Restaurant> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Restaurant[] findByUuid_C_PrevAndNext(long restaurantId,
        String uuid, long companyId, OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = findByPrimaryKey(restaurantId);

        Session session = null;

        try {
            session = openSession();

            Restaurant[] array = new RestaurantImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, restaurant, uuid,
                    companyId, orderByComparator, true);

            array[1] = restaurant;

            array[2] = getByUuid_C_PrevAndNext(session, restaurant, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Restaurant getByUuid_C_PrevAndNext(Session session,
        Restaurant restaurant, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RESTAURANT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RestaurantModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(restaurant);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Restaurant> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the restaurants where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Restaurant restaurant : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(restaurant);
        }
    }

    /**
     * Returns the number of restaurants where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_RESTAURANT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the restaurants where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Restaurant> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Restaurant> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
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
    @Override
    public List<Restaurant> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Restaurant> list = (List<Restaurant>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Restaurant restaurant : list) {
                if ((groupId != restaurant.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_RESTAURANT_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(RestaurantModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Restaurant>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Restaurant>(list);
                } else {
                    list = (List<Restaurant>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Restaurant findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = fetchByGroupId_First(groupId, orderByComparator);

        if (restaurant != null) {
            return restaurant;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRestaurantException(msg.toString());
    }

    /**
     * Returns the first restaurant in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching restaurant, or <code>null</code> if a matching restaurant could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Restaurant> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Restaurant findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = fetchByGroupId_Last(groupId, orderByComparator);

        if (restaurant != null) {
            return restaurant;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRestaurantException(msg.toString());
    }

    /**
     * Returns the last restaurant in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching restaurant, or <code>null</code> if a matching restaurant could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<Restaurant> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Restaurant[] findByGroupId_PrevAndNext(long restaurantId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = findByPrimaryKey(restaurantId);

        Session session = null;

        try {
            session = openSession();

            Restaurant[] array = new RestaurantImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, restaurant, groupId,
                    orderByComparator, true);

            array[1] = restaurant;

            array[2] = getByGroupId_PrevAndNext(session, restaurant, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Restaurant getByGroupId_PrevAndNext(Session session,
        Restaurant restaurant, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RESTAURANT_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(RestaurantModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(restaurant);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Restaurant> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the restaurants that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching restaurants that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Restaurant> filterFindByGroupId(long groupId)
        throws SystemException {
        return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Restaurant> filterFindByGroupId(long groupId, int start, int end)
        throws SystemException {
        return filterFindByGroupId(groupId, start, end, null);
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
    @Override
    public List<Restaurant> filterFindByGroupId(long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId(groupId, start, end, orderByComparator);
        }

        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(3 +
                    (orderByComparator.getOrderByFields().length * 3));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_RESTAURANT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_RESTAURANT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_RESTAURANT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            if (getDB().isSupportsInlineDistinct()) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator, true);
            } else {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
                    orderByComparator, true);
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(RestaurantModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(RestaurantModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Restaurant.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            if (getDB().isSupportsInlineDistinct()) {
                q.addEntity(_FILTER_ENTITY_ALIAS, RestaurantImpl.class);
            } else {
                q.addEntity(_FILTER_ENTITY_TABLE, RestaurantImpl.class);
            }

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            return (List<Restaurant>) QueryUtil.list(q, getDialect(), start, end);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
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
    @Override
    public Restaurant[] filterFindByGroupId_PrevAndNext(long restaurantId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchRestaurantException, SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return findByGroupId_PrevAndNext(restaurantId, groupId,
                orderByComparator);
        }

        Restaurant restaurant = findByPrimaryKey(restaurantId);

        Session session = null;

        try {
            session = openSession();

            Restaurant[] array = new RestaurantImpl[3];

            array[0] = filterGetByGroupId_PrevAndNext(session, restaurant,
                    groupId, orderByComparator, true);

            array[1] = restaurant;

            array[2] = filterGetByGroupId_PrevAndNext(session, restaurant,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Restaurant filterGetByGroupId_PrevAndNext(Session session,
        Restaurant restaurant, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        if (getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_RESTAURANT_WHERE);
        } else {
            query.append(_FILTER_SQL_SELECT_RESTAURANT_NO_INLINE_DISTINCT_WHERE_1);
        }

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (!getDB().isSupportsInlineDistinct()) {
            query.append(_FILTER_SQL_SELECT_RESTAURANT_NO_INLINE_DISTINCT_WHERE_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                if (getDB().isSupportsInlineDistinct()) {
                    query.append(_ORDER_BY_ENTITY_ALIAS);
                } else {
                    query.append(_ORDER_BY_ENTITY_TABLE);
                }

                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            if (getDB().isSupportsInlineDistinct()) {
                query.append(RestaurantModelImpl.ORDER_BY_JPQL);
            } else {
                query.append(RestaurantModelImpl.ORDER_BY_SQL);
            }
        }

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Restaurant.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        SQLQuery q = session.createSQLQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        if (getDB().isSupportsInlineDistinct()) {
            q.addEntity(_FILTER_ENTITY_ALIAS, RestaurantImpl.class);
        } else {
            q.addEntity(_FILTER_ENTITY_TABLE, RestaurantImpl.class);
        }

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(restaurant);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Restaurant> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the restaurants where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (Restaurant restaurant : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(restaurant);
        }
    }

    /**
     * Returns the number of restaurants where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_RESTAURANT_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of restaurants that the user has permission to view where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching restaurants that the user has permission to view
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int filterCountByGroupId(long groupId) throws SystemException {
        if (!InlineSQLHelperUtil.isEnabled(groupId)) {
            return countByGroupId(groupId);
        }

        StringBundler query = new StringBundler(2);

        query.append(_FILTER_SQL_COUNT_RESTAURANT_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
                Restaurant.class.getName(),
                _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

        Session session = null;

        try {
            session = openSession();

            SQLQuery q = session.createSQLQuery(sql);

            q.addScalar(COUNT_COLUMN_NAME,
                com.liferay.portal.kernel.dao.orm.Type.LONG);

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            Long count = (Long) q.uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    /**
     * Caches the restaurant in the entity cache if it is enabled.
     *
     * @param restaurant the restaurant
     */
    @Override
    public void cacheResult(Restaurant restaurant) {
        EntityCacheUtil.putResult(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantImpl.class, restaurant.getPrimaryKey(), restaurant);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { restaurant.getUuid(), restaurant.getGroupId() },
            restaurant);

        restaurant.resetOriginalValues();
    }

    /**
     * Caches the restaurants in the entity cache if it is enabled.
     *
     * @param restaurants the restaurants
     */
    @Override
    public void cacheResult(List<Restaurant> restaurants) {
        for (Restaurant restaurant : restaurants) {
            if (EntityCacheUtil.getResult(
                        RestaurantModelImpl.ENTITY_CACHE_ENABLED,
                        RestaurantImpl.class, restaurant.getPrimaryKey()) == null) {
                cacheResult(restaurant);
            } else {
                restaurant.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all restaurants.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RestaurantImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RestaurantImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the restaurant.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Restaurant restaurant) {
        EntityCacheUtil.removeResult(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantImpl.class, restaurant.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(restaurant);
    }

    @Override
    public void clearCache(List<Restaurant> restaurants) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Restaurant restaurant : restaurants) {
            EntityCacheUtil.removeResult(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
                RestaurantImpl.class, restaurant.getPrimaryKey());

            clearUniqueFindersCache(restaurant);
        }
    }

    protected void cacheUniqueFindersCache(Restaurant restaurant) {
        if (restaurant.isNew()) {
            Object[] args = new Object[] {
                    restaurant.getUuid(), restaurant.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                restaurant);
        } else {
            RestaurantModelImpl restaurantModelImpl = (RestaurantModelImpl) restaurant;

            if ((restaurantModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        restaurant.getUuid(), restaurant.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    restaurant);
            }
        }
    }

    protected void clearUniqueFindersCache(Restaurant restaurant) {
        RestaurantModelImpl restaurantModelImpl = (RestaurantModelImpl) restaurant;

        Object[] args = new Object[] {
                restaurant.getUuid(), restaurant.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((restaurantModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    restaurantModelImpl.getOriginalUuid(),
                    restaurantModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new restaurant with the primary key. Does not add the restaurant to the database.
     *
     * @param restaurantId the primary key for the new restaurant
     * @return the new restaurant
     */
    @Override
    public Restaurant create(long restaurantId) {
        Restaurant restaurant = new RestaurantImpl();

        restaurant.setNew(true);
        restaurant.setPrimaryKey(restaurantId);

        String uuid = PortalUUIDUtil.generate();

        restaurant.setUuid(uuid);

        return restaurant;
    }

    /**
     * Removes the restaurant with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param restaurantId the primary key of the restaurant
     * @return the restaurant that was removed
     * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant remove(long restaurantId)
        throws NoSuchRestaurantException, SystemException {
        return remove((Serializable) restaurantId);
    }

    /**
     * Removes the restaurant with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the restaurant
     * @return the restaurant that was removed
     * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant remove(Serializable primaryKey)
        throws NoSuchRestaurantException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Restaurant restaurant = (Restaurant) session.get(RestaurantImpl.class,
                    primaryKey);

            if (restaurant == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRestaurantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(restaurant);
        } catch (NoSuchRestaurantException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Restaurant removeImpl(Restaurant restaurant)
        throws SystemException {
        restaurant = toUnwrappedModel(restaurant);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(restaurant)) {
                restaurant = (Restaurant) session.get(RestaurantImpl.class,
                        restaurant.getPrimaryKeyObj());
            }

            if (restaurant != null) {
                session.delete(restaurant);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (restaurant != null) {
            clearCache(restaurant);
        }

        return restaurant;
    }

    @Override
    public Restaurant updateImpl(com.smile.plugins.model.Restaurant restaurant)
        throws SystemException {
        restaurant = toUnwrappedModel(restaurant);

        boolean isNew = restaurant.isNew();

        RestaurantModelImpl restaurantModelImpl = (RestaurantModelImpl) restaurant;

        if (Validator.isNull(restaurant.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            restaurant.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (restaurant.isNew()) {
                session.save(restaurant);

                restaurant.setNew(false);
            } else {
                session.merge(restaurant);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RestaurantModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((restaurantModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        restaurantModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { restaurantModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((restaurantModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        restaurantModelImpl.getOriginalUuid(),
                        restaurantModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        restaurantModelImpl.getUuid(),
                        restaurantModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((restaurantModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        restaurantModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { restaurantModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
            RestaurantImpl.class, restaurant.getPrimaryKey(), restaurant);

        clearUniqueFindersCache(restaurant);
        cacheUniqueFindersCache(restaurant);

        return restaurant;
    }

    protected Restaurant toUnwrappedModel(Restaurant restaurant) {
        if (restaurant instanceof RestaurantImpl) {
            return restaurant;
        }

        RestaurantImpl restaurantImpl = new RestaurantImpl();

        restaurantImpl.setNew(restaurant.isNew());
        restaurantImpl.setPrimaryKey(restaurant.getPrimaryKey());

        restaurantImpl.setUuid(restaurant.getUuid());
        restaurantImpl.setRestaurantId(restaurant.getRestaurantId());
        restaurantImpl.setGroupId(restaurant.getGroupId());
        restaurantImpl.setCompanyId(restaurant.getCompanyId());
        restaurantImpl.setUserId(restaurant.getUserId());
        restaurantImpl.setUserName(restaurant.getUserName());
        restaurantImpl.setCreateDate(restaurant.getCreateDate());
        restaurantImpl.setModifiedDate(restaurant.getModifiedDate());
        restaurantImpl.setStatus(restaurant.getStatus());
        restaurantImpl.setStatusByUserId(restaurant.getStatusByUserId());
        restaurantImpl.setStatusByUserName(restaurant.getStatusByUserName());
        restaurantImpl.setStatusDate(restaurant.getStatusDate());
        restaurantImpl.setEmailAddress(restaurant.getEmailAddress());
        restaurantImpl.setName(restaurant.getName());
        restaurantImpl.setCountryId(restaurant.getCountryId());
        restaurantImpl.setRegionId(restaurant.getRegionId());
        restaurantImpl.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantImpl.setStreet1(restaurant.getStreet1());
        restaurantImpl.setStreet2(restaurant.getStreet2());
        restaurantImpl.setZip(restaurant.getZip());
        restaurantImpl.setCity(restaurant.getCity());
        restaurantImpl.setLogoId(restaurant.getLogoId());
        restaurantImpl.setLogoDescription(restaurant.getLogoDescription());
        restaurantImpl.setDescription(restaurant.getDescription());

        return restaurantImpl;
    }

    /**
     * Returns the restaurant with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the restaurant
     * @return the restaurant
     * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant findByPrimaryKey(Serializable primaryKey)
        throws NoSuchRestaurantException, SystemException {
        Restaurant restaurant = fetchByPrimaryKey(primaryKey);

        if (restaurant == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchRestaurantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return restaurant;
    }

    /**
     * Returns the restaurant with the primary key or throws a {@link com.smile.plugins.NoSuchRestaurantException} if it could not be found.
     *
     * @param restaurantId the primary key of the restaurant
     * @return the restaurant
     * @throws com.smile.plugins.NoSuchRestaurantException if a restaurant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant findByPrimaryKey(long restaurantId)
        throws NoSuchRestaurantException, SystemException {
        return findByPrimaryKey((Serializable) restaurantId);
    }

    /**
     * Returns the restaurant with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the restaurant
     * @return the restaurant, or <code>null</code> if a restaurant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Restaurant restaurant = (Restaurant) EntityCacheUtil.getResult(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
                RestaurantImpl.class, primaryKey);

        if (restaurant == _nullRestaurant) {
            return null;
        }

        if (restaurant == null) {
            Session session = null;

            try {
                session = openSession();

                restaurant = (Restaurant) session.get(RestaurantImpl.class,
                        primaryKey);

                if (restaurant != null) {
                    cacheResult(restaurant);
                } else {
                    EntityCacheUtil.putResult(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
                        RestaurantImpl.class, primaryKey, _nullRestaurant);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(RestaurantModelImpl.ENTITY_CACHE_ENABLED,
                    RestaurantImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return restaurant;
    }

    /**
     * Returns the restaurant with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param restaurantId the primary key of the restaurant
     * @return the restaurant, or <code>null</code> if a restaurant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Restaurant fetchByPrimaryKey(long restaurantId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) restaurantId);
    }

    /**
     * Returns all the restaurants.
     *
     * @return the restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Restaurant> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Restaurant> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Restaurant> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Restaurant> list = (List<Restaurant>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_RESTAURANT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_RESTAURANT;

                if (pagination) {
                    sql = sql.concat(RestaurantModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Restaurant>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Restaurant>(list);
                } else {
                    list = (List<Restaurant>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the restaurants from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Restaurant restaurant : findAll()) {
            remove(restaurant);
        }
    }

    /**
     * Returns the number of restaurants.
     *
     * @return the number of restaurants
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_RESTAURANT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the restaurant persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.smile.plugins.model.Restaurant")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Restaurant>> listenersList = new ArrayList<ModelListener<Restaurant>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Restaurant>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RestaurantImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
