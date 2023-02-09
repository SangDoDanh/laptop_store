// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  API_URL: 'http://localhost:8080',
  PRODUCT_GROUPS: '/api/v1/product-groups',
  PRODUCT_GROUP_DETAIL: '/api/v1/product-groups/detail/',
  SIZE_INCH: '/api/v1/size-inch',
  AUTH_LOGIN: '/api/auth/signin',
  PRODUCT_GROUPS_SEARCH: '/api/v1/product-groups/search',
  API_URL_PRODUCER_FOR_LAP: '/api/v1/producer/for-lap',
  PRODUCT_GROUPS_SEARCH_AND_PAGE: '/api/v1/product-groups/search-page',
  PRODUCT_CART_BY_USER: '/api/v1/cart',
  PRODUCT_DETAIL_LIST: '/api/v1/product-groups/products-list-detail',
  ADD_TO_CART: '/api/v1/cart/add-to-cart',
  CART_UPDATE_QUALITY: '/api/v1/cart/update-quality',
  PAY_ORDERDETAIL: '/api/v1/cart/update-pay-status',
  UPDATE_REMOVE_STATUS: '/api/v1/cart/update-remove-status',
  SHIP: '/api/v1/cart/get-all-ship',
  HISTORY_PAY: '/api/v1/product-groups/products-list-pay',
  CUSTOMER: '/api/v1/customer/account-id'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
