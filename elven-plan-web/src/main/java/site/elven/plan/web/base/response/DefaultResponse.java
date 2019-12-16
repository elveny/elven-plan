package site.elven.plan.web.base.response;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class DefaultResponse<T> extends BaseResponse {

    private T data;


    /**
     * 构造一个成功的返回对象
     */
    public DefaultResponse () {
        super ();
    }

    /**
     * 构造一个成功的返回对象
     *
     * @param data
     */
    public DefaultResponse (T data) {
        super ();
        setData (data);
    }

    public DefaultResponse (ResultCodeable resultCode) {
        super (resultCode);
    }

    public DefaultResponse (ResultCodeable resultCode, T data) {
        super (resultCode);
        setData (data);
    }

    public DefaultResponse (String resultCode, String resultMessage) {
        super (resultCode, resultMessage);
    }

    public DefaultResponse (String resultCode, String resultMessage, T data) {
        super (resultCode, resultMessage);
        setData (data);
    }

    /**
     * 建议使用构造函数
     *
     * @param data
     * @param <T>
     *
     * @return
     * @see DefaultResponse#DefaultResponse(Object)
     */
    public static <T> DefaultResponse success (T data) {
        return new DefaultResponse<T> (data);
    }

    public static DefaultResponse success () {
        return new DefaultResponse ();
    }

    public static DefaultResponse newResponse (String code, String msg) {
        return new DefaultResponse (code, msg);
    }

    public static DefaultResponse newResponse (ResultCodeable resultCode) {
        return new DefaultResponse (resultCode);
    }

    @Override
    public DefaultResponse<T> setToSuccess () {
        super.setToSuccess ();
        return this;
    }

    @Override
    public DefaultResponse<T> setStatus (ResultCodeable resultCode) {
        super.setStatus (resultCode);
        return this;
    }

    @Override
    public DefaultResponse<T> setStatus (String resultCode, String resultMessage) {
        super.setStatus (resultCode, resultMessage);
        return this;
    }

    @Override
    public <RESPONSE extends BaseResponse> DefaultResponse<T> copyResult (RESPONSE response) {
        super.copyResult (response);
        return this;
    }


    /**
     * 对象转换
     *
     * @param origin   原始对象
     * @param parser   转换器
     * @param <ORIGIN> 原始对象类型
     * @param <TARGET> 目标对象类型
     *
     * @return
     */
    protected static <ORIGIN, TARGET> TARGET convert (ORIGIN origin,
                                                   IResponseParser<ORIGIN, TARGET> parser) {
        return parser.parse (origin);
    }


    /**
     * 对象转换
     *
     * @param list     原始对象列表
     * @param parser   转换器
     * @param <ORIGIN> 原始对象类型
     * @param <TARGET> 目标对象类型
     *
     * @return
     */
    protected static <ORIGIN, TARGET> List<TARGET> convert (List<ORIGIN> list,
                                                            IResponseParser<ORIGIN, TARGET> parser) {
        List<TARGET> targetList;
        if (CollectionUtils.isEmpty (list)) {
            targetList = new ArrayList<>();
        } else {
            targetList = new ArrayList<> (list.size ());
            list.forEach ((item) -> targetList.add (parser.parse (item)));
        }
        return targetList;
    }

    /**
     * 从一个 DefaultResponse 复制到 另一个 DefaultResponse
     *
     * @param origin   原DefaultResponse
     * @param parser   对象转换器
     * @param <ORIGIN> 原DefaultResponse 的对象类型
     * @param <TARGET> 目标DefaultResponse 的对象类型
     *
     * @return
     * @see DefaultResponse#convert(site.elven.plan.web.base.response.DefaultResponse, site.elven.plan.web.base.response.IResponseParser)
     */
    @Deprecated
    public static <ORIGIN, TARGET> DefaultResponse copyResult (DefaultResponse<ORIGIN> origin,
                                                               IResponseParser<ORIGIN, TARGET> parser) {
        return convert (origin,parser);
    }

    /**
     * 从一个 DefaultResponse 复制到 另一个 DefaultResponse
     *
     * @param origin   原DefaultResponse
     * @param parser   对象转换器
     * @param <ORIGIN> 原DefaultResponse 的对象类型
     * @param <TARGET> 目标DefaultResponse 的对象类型
     *
     * @return
     */
    public static <ORIGIN, TARGET> DefaultResponse<TARGET> convert (DefaultResponse<ORIGIN> origin,
                                                                IResponseParser<ORIGIN, TARGET> parser) {
        DefaultResponse<TARGET> response = new DefaultResponse<TARGET> ();
        response.copyResult (origin);

        response.setData (parser.parse (origin.getData ()));
        return response;
    }


    public T getData () {
        return data;
    }

    public DefaultResponse<T> setData (T data) {
        this.data = data;
        return this;
    }
}