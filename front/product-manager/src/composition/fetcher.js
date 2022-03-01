import {ref} from "vue";
import {api, BadRequestError, NotFoundError, UnauthorizedError} from "../helper/api";

export function useFetch(url) {
    const loading = ref(false);
    const data = ref([]);
    const error = ref(false);
    const fetchData = async () => {
        console.log('fetch ' + url);
        loading.value = true;
        try {
            data.value = await api(url);
        } catch (e) {
            if (e instanceof NotFoundError) {
                error.value = 404;
            }
            if (e instanceof UnauthorizedError) {
               error.value = 403;
            }
            if (e instanceof BadRequestError) {
                error.value = 400;
            }
        }

        loading.value = false;
    }

    return {
        loading,
        data,
        error,
        fetchData
    }
}