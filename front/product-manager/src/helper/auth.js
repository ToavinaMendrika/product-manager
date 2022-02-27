export function isAuthenticate() {
    return window.localStorage.getItem('auth-tok') !== null;
}