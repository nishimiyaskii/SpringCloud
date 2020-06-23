package to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aimerrhythms
 * @data 2020/6/23 23:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonTo {

    private Integer age;
    private String name;
    private Integer gender;
    private String address;

}
