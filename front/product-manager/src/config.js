export const BASE_URL = 'http://localhost:8081/api'
export const config = {
    urls: {
        signIn : BASE_URL + '/authenticate',
        addProduct: BASE_URL + '/products',
        getProducts: BASE_URL + '/products',
    }
}